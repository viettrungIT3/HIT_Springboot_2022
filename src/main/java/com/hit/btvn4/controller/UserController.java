package com.hit.btvn4.controller;

import com.hit.btvn4.dto.UserDTO;
import com.hit.btvn4.model.User;
import com.hit.btvn4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") Long id) {
        Optional<User> user = userRepository.findById(id);

        return ResponseEntity.status(200).body(user.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.status(200).body("Success!");
    }




}
