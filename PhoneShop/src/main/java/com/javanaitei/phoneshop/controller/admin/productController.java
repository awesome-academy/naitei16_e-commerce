package com.javanaitei.phoneshop.controller.admin;

import com.javanaitei.phoneshop.model.CategoryModel;
import com.javanaitei.phoneshop.model.ProductModel;
import com.javanaitei.phoneshop.service.CategoryService;
import com.javanaitei.phoneshop.service.ProductService;
import com.javanaitei.phoneshop.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class productController {
    private static final Logger logger = Logger.getLogger(productController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String product(Model model) {
//        String[] products = { "Honda", "BMW", "Ford", "Mazda", "Honda1", "BMW1", "Ford1", "Mazda1", "Honda2", "BMW2", "Ford2", "Mazda2" };
        model.addAttribute("products", productService.findAll());
        return "admin/product/product";
    }

    @PostMapping("/product-create")
    public String productCreate() {
        return "admin/product/product-create";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail() {
        return "admin/product/product-detail";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        List<CategoryModel> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/product/categories";
    }

    @GetMapping("/brands")
    public String brands(Model model) {
        model.addAttribute("brands", productService.findAll());
        logger.info(model);
        return "admin/product/brands";

    }
}
