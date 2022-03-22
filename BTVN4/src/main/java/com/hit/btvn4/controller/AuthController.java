package com.hit.btvn4.controller;

import com.hit.btvn4.model.User;
import com.hit.btvn4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userRepository.findAll());

        return "users";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("err", "");

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        List<User> users = userRepository.findAll();

        if (users.contains(user)) {
            return "redirect:/users";
        }

        model.addAttribute("err", "Incorrect username or password!");
        return "login";
    }


}
