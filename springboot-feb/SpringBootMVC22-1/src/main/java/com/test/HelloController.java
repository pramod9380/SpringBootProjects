package com.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	/*
	@RequestMapping("/submit")
	public String submitPage(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		String str = name+" "+pass;
		
		model.addAttribute("info", str);
		
		return "details";
	}
 */
	
	@RequestMapping("/submit")
	public String submitPage(@RequestParam("user")String name, @RequestParam("pwd")String pass, Model model)
	{
		
		String str = name+" "+pass;
		
		model.addAttribute("info", str);
		
		return "details";
	}
}
