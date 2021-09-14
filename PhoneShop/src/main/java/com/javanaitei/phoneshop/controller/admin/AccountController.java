package com.javanaitei.phoneshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

    @GetMapping("/accounts")
    public String users(Model model) {
        String[] accounts = { "Honda", "BMW", "Ford", "Mazda", "Honda1", "BMW1", "Ford1", "Mazda1", "Honda2", "BMW2", "Ford2", "Mazda2" };
        model.addAttribute("accounts", accounts);
        return "admin/accounts/accounts";
    }

    @GetMapping(value = {"", "/"})
    public String list(Model model) {
        return "admin/accounts/accounts";
    }

}
