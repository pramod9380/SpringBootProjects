package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.User;

@Controller
public class UserController {
	
	@RequestMapping("/loginform")
	public String userLoginPage()
	{
		return "login";
	}
	
	@RequestMapping("/submit")
	public String submitForm(HttpServletRequest request, Model model)
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		User u = new User();
		
		u.setUserName(user);
		u.setPassword(pass);
		
		model.addAttribute("info", u);
		
		return "details";
	}
	
	@RequestMapping("/submit1")
	public String submitForm(@RequestParam("user") String user, @RequestParam("pwd") String pass, Model model)
	{
		User u = new User();
		
		u.setUserName(user);
		u.setPassword(pass);
		
		model.addAttribute("info", u);
		
		return "details";
	}

}
