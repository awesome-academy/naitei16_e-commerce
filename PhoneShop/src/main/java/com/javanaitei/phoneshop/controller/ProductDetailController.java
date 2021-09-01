package com.javanaitei.phoneshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
    @GetMapping(value = {"/product/{product_id}/product-detail"})
    public String index() {
        return "productDetail/detail";
    }
}
