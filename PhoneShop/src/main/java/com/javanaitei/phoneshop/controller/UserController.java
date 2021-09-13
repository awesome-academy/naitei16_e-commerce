package com.javanaitei.phoneshop.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javanaitei.phoneshop.model.UserModel;
import com.javanaitei.phoneshop.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/sign-in")
    public String login(Locale locale, Model model) {
        model.addAttribute("user", new UserModel());
        return "auth/sign-in";
    }

    @GetMapping(value = "/sign-up")
    public String add(Locale locale, Model model) {
        model.addAttribute("user", new UserModel());
        return "auth/sign-up";
    }

    @PostMapping(value = "/sign-up")
    public String create(@ModelAttribute("user") @Validated UserModel userModel, BindingResult bindingResult,
                         Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        if (bindingResult.hasErrors()) {
            return "auth/sign-up";
        }
        userService.addUser(userModel);
        return "redirect:/sign-in";
    }
}
