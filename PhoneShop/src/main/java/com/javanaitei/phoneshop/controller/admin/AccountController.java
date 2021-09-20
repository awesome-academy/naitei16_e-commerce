package com.javanaitei.phoneshop.controller.admin;

import com.javanaitei.phoneshop.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

    private static final Logger logger = Logger.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    //show all
    @GetMapping(value = {"", "/"})
    public String list(Model model) {
        logger.info("Show all account");
        model.addAttribute("accounts", userService.findAll());
        return "admin/accounts/accounts";
    }

}
