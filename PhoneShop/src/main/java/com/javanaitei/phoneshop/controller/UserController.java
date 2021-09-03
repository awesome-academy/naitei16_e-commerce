package com.javanaitei.phoneshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping ("/sign-in")
    public String signin() {
        return "auth/sign-in";
    }

    @GetMapping("/sign-up")
    public String signup() {
        return "auth/sign-up";
    }
}
