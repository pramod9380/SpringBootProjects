package com.example.springbootformvalidations.controller;

import com.example.springbootformvalidations.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;


@Controller
public class UserController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/userlogin")
    public String login(Model model, User user){
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping(value = "/usersubmit",method = RequestMethod.POST)
    public String submitUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        System.out.println("submit method called!!!!");

        if(result.hasErrors()){
            return "login";
        }else {
            return "success";
        }
    }
}
