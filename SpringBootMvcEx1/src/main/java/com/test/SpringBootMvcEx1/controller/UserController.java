package com.test.SpringBootMvcEx1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/userhomepage")
	public String userHome()
	{
		return "userhome";
	}

}
