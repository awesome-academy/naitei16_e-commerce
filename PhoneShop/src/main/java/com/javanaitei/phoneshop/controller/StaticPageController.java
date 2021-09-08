package com.javanaitei.phoneshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticPageController {
    @GetMapping(value = {"", "/", "/home"})
    public String home() {
        return "pages/home";
    }

    @GetMapping ("/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "pages/contact";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "pages/checkout";
    }

    @GetMapping("/error")
    public String error() {
        return "templates/error";
    }
}
