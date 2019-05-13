package edu.mum.waa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/login")
    public String GetLoginForm() {return "login";}


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
