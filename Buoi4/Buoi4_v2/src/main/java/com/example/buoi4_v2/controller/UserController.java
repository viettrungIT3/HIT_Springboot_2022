package com.example.buoi4_v2.controller;


import com.example.buoi4_v2.model.User;
import com.example.buoi4_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.status(200).body(users);
    }


}
