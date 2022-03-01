package com.hit.buoi2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String getHome() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    // Thymeleaf
//    @GetMapping("/login")
//    public String getLoginPage(Model model) {
////        Account account = new Account("Trung123", "123");
////        model.addAttribute("acc", account);
//        model.addAttribute("acc", new Account());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String getResult(@ModelAttribute Account account) {
//        if ( account.getUsername().equals("admin") && account.getPassword().equals("123")) {
//            return "index";
//        }
//        return "redirect:login";
//    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView mav = new ModelAndView("login");

        mav.addObject("acc", new Account());

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("admin", "123"));
        accounts.add(new Account("Trung123", "123"));
        accounts.add(new Account("abc123", "123"));

        mav.addObject("accs", accounts);
        return mav;
    }

    @PostMapping("/login")
    public String getResult(@ModelAttribute Account account) {
        if (account.getUsername().equals("admin") && account.getPassword().equals("123")) {
            return "index";
        }
        return "redirect:login";
    }

}
