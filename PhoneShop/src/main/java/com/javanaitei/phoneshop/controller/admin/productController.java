package com.javanaitei.phoneshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class productController {
    @GetMapping("/product")
    public String product(Model model) {
        String[] products = { "Honda", "BMW", "Ford", "Mazda", "Honda1", "BMW1", "Ford1", "Mazda1", "Honda2", "BMW2", "Ford2", "Mazda2" };
        model.addAttribute("products", products);
        return "admin/product/product";
    }

    @GetMapping("/product/product-create")
    public String productCreate() {
        return "admin/product/product-create";
    }

    @GetMapping("/product/product-detail/{id}")
    public String productDetail() {
        return "admin/product/product-detail";
    }

    @GetMapping("/product/categories")
    public String categories() {
        return "admin/product/categories";
    }

    @GetMapping("/product/brands")
    public String brands(Model model) {
        String[] brands = { "Honda", "BMW", "Ford", "Mazda", "Honda1", "BMW1", "Ford1", "Mazda1", "Honda2", "BMW2", "Ford2", "Mazda2" };
        model.addAttribute("brands", brands);
        return "admin/product/brands";
    }
}
