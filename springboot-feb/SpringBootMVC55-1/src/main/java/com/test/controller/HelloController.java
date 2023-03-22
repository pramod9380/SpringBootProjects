package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String homePge()
	{
		return "index";
	}
	
	@RequestMapping("/greet")
	public String sayHello()
	{
		return "home";
	}
	
	@RequestMapping("/grtagain")
	public String sayHelloAgain()
	{
		return "again";
	}

}
