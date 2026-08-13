package com.workshop.course.services;

import com.workshop.course.entities.User;
import com.workshop.course.repositories.UserRepository;
import com.workshop.course.services.middlewares.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public User delete(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User update(Long id, User user) {

        User updateUser = repository.getReferenceById(id);
        updateData(updateUser, user);
        return repository.save(updateUser);

    }


    public void updateData(User user, User user1) {
        user.setName(user1.getName());
        user.setEmail(user1.getEmail());
        user.setPhone(user1.getPhone());
    }

}
