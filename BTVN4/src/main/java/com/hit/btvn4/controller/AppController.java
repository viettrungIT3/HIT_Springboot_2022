package com.hit.btvn4.controller;

import com.hit.btvn4.dto.UserDTO;
import com.hit.btvn4.model.User;
import com.hit.btvn4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    //create
    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("user", new User());

        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") UserDTO userDTO,
                                    @RequestParam("password2") String password2,
                                    Model model) {

        // Chưa làm
//        if ( ) {
//            model.addAttribute("err", "User already exists!");
//            return "/create";
//        }

        if ( !password2.equals(userDTO.getPassword())) {
            model.addAttribute("err", "Incorrect password!");
            return "/create";
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);

        return "redirect:/users";
    }

//    @GetMapping("/edit")
//    public String editUser(@RequestParam("id") Long id, Model model) {
//        model.addAttribute("user", userRepository.getById(id));
//        model.addAttribute("err", "");
//
//        return "edit";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute("user") User user,
//                           @RequestParam(value = "Username", required = false) String Username,
//                           @RequestParam(value = "fullName", required = false) String fullName,
//                           @RequestParam(value = "passwordC", required = false) String passwordC,
//                           @RequestParam(value = "passwordN", required = false) String passwordN,
//                           @RequestParam(value = "passwordN2", required = false) String passwordN2,
//                           @RequestParam(value = "submit", required = false) String submit,
//                           @RequestParam(value = "cancel", required = false) String cancel,
//                           Model model) {
//
////        if ( !passwordC.equals(user.getPassword())) {
////            model.addAttribute("err", "Incorrect password!");
////            return "/edit";
////        }
//        if ( !passwordN.equals(passwordN2)) {
//            model.addAttribute("err", "Your new password does not match confirmation!");
//            return "/edit";
//        }
//
////        System.out.println(cancel.equals("CANCEL"));
//
////        if (cancel.equals("CANCEL"))
////            return "redirect:/users";
//
//        User newUser = userRepository.findById(user.getId()).get();
//
//        newUser.setUsername(Username);
//        newUser.setFullName(fullName);
//        newUser.setPassword(passwordN);
////        newUser.setTimeUpdated(new Date());
//
//        userRepository.save(newUser);
//
//        return "redirect:/users";
//    }


    //edit
    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getById(id));

        return "edit";
    }

    @PostMapping("edit")
    public String processEditUser(@ModelAttribute("user") User user) {
        User newUser = userRepository.findById(user.getId()).get();

        newUser.setUsername(user.getUsername());
        newUser.setFullName(user.getFullName());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);

        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
