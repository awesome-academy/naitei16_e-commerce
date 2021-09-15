package com.javanaitei.phoneshop.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javanaitei.phoneshop.model.CustomUserDetails;
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
    
    @GetMapping(value = "/{id}")
    public String show(@PathVariable Long id, Model model, Authentication authentication) {
        UserModel user = userService.findUser(id);
        if (user == null)
            return "templates/error";
        if (authentication != null) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            if (userDetails.getUser().getId().equals(id)) {
                model.addAttribute("isCurrentUser", true);
            } else {
                model.addAttribute("isCurrentUser", false);
            }
        }
        model.addAttribute("user", user);
        return "user/show";
    }
    
    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Long id, Model model, Authentication authentication) {
        UserModel user = userService.findUser(id);
        if (user == null)
            return "templates/error";
        String checkAccess = checkAccess(id, authentication);
        if (checkAccess != null)
            return checkAccess;
        model.addAttribute("user", user);
        return "user/edit";
    }
    
    @PutMapping(value = "/{id}/edit")
    public String update(@ModelAttribute("user") @Validated UserModel userModel, BindingResult bindingResult, Model model,
                         final RedirectAttributes redirectAttributes, HttpServletRequest request, Authentication authentication) throws Exception {
        logger.info("result" + bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        String checkAccess = checkAccess(userModel.getId(), authentication);
        if (checkAccess != null)
            return checkAccess;
        UserModel user = userService.editUser(userModel);
        return "redirect:/user/" + user.getId();
    }
    
    @GetMapping(value = "/{id}/password")
    public String changePassword(@PathVariable Long id, Model model, Authentication authentication) {
        UserModel user = userService.findUser(id);
        if (user == null)
            return "templates/error";
        String checkAccess = checkAccess(id, authentication);
        if (checkAccess != null)
            return checkAccess;
        model.addAttribute("user", user);
        return "user/password";
    }

    @PutMapping(value = "/{id}/password")
    public String updatePassword(@ModelAttribute("user") @Validated UserModel userModel, BindingResult bindingResult, Model model,
                                 final RedirectAttributes redirectAttributes, HttpServletRequest request, Authentication authentication) throws Exception {
        logger.info("result" + bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/password";
        }
        String checkAccess = checkAccess(userModel.getId(), authentication);
        if (checkAccess != null)
            return checkAccess;
        UserModel user = userService.changePassword(userModel);
        return "redirect:/user/" + user.getId();
    }
    
    public String checkAccess(Long id, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (!userDetails.getUser().getId().equals(id)) {
            return "templates/access_denied";
        }
        return null;
    }
    
}
