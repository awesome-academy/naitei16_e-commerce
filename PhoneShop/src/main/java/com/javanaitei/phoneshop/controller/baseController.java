package com.javanaitei.phoneshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class baseController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
