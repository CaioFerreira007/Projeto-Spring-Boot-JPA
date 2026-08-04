package com.workshop.course.entities.resources;

import com.workshop.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources  {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L,"Maria","9999999999","maria@gmail.com","senha123");
        return ResponseEntity.ok().body(user);
    }

}
