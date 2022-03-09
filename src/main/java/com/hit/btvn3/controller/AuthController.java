package com.hit.btvn3.controller;

import com.hit.btvn3.model.Store;
import com.hit.btvn3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController{

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("acc", new User());
        return mav;
    }

    @GetMapping("/success")
    public ModelAndView success() {
        ModelAndView mav = new ModelAndView("success");
        mav.addObject("accs", Store.users);
        return mav;
    }

    @PostMapping("/success")
    public String getResult(@RequestParam(value = "username") String usernameP,
                            @RequestParam(value = "password") String passwordP, @ModelAttribute Store store){
        for ( User user : store.getUsers()) {
            if (user.getUsername().equals(usernameP) && user.getPassword().equals(passwordP)) {
                return "success";
            }
        }

        return "redirect:login";
    }


}
