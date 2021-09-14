package com.javanaitei.phoneshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class orderController {
    @GetMapping("/order")
    public String order(Model model) {
        String[] orders = { "Honda", "BMW", "Ford", "Mazda", "Honda1", "BMW1", "Ford1", "Mazda1", "Honda2", "BMW2", "Ford2", "Mazda2" };
        model.addAttribute("orders", orders);
        return "admin/order/order";
    }

    @GetMapping("/order/orderDetail/{id}/")
    public String orderDetail() {
        return "admin/order/orderDetail";
    }
}
