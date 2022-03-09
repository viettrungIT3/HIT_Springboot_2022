package com.hit.btvn3.controller;

import com.hit.btvn3.model.Store;
import com.hit.btvn3.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public List<User> listUser() {
        return Store.users;
    }
}
