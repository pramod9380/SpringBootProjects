package com.test.SpringBootMvcEx1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping("/producthomepage")
	public String productHomePage() {
		return "producthome";
	}

}
