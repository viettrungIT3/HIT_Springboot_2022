package com.hit.buoi5.controller;

import com.hit.buoi5.dto.UserDTO;
import com.hit.buoi5.exception.DuplicateException;
import com.hit.buoi5.exception.NotFoundException;
import com.hit.buoi5.model.User;
import com.hit.buoi5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
    * GET   : /api/v1/users
    * GET   : /api/v1/users/{id}
    * POST  : /api/v1/users
    * PATCH : /api/v1/users/{id}
    * DELETE: /api/v1/users/{id}
    * */

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable("id") Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new NotFoundException("Không tìm thấy user id: " + id);
        }
        return ResponseEntity.status(200).body(user.get());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        User user = userRepository.findUserByUsername(userDTO.getUsername());

        if (user != null) {
            throw new DuplicateException("Username: " + user.getUsername() + " đã tồn tại trong CSDL.");
        }

        user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullName());
        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUserByID(@PathVariable("id") Long id,
                                          @RequestBody UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tìm thấy User có id là: " + id);
        }

        User user = optionalUser.get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserByID(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tìm thấy User có id là: " + id);
        }

        userRepository.deleteById(id);

        return ResponseEntity.status(200).body("Xóa thành công.");
    }

}
