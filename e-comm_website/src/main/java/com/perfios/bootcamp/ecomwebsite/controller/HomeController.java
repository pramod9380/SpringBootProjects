package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.exception.ProductNotFoundException;
import com.perfios.bootcamp.ecomwebsite.global.GlobalData;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.CategoryImpl;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    CategoryImpl categoryImpl;

    @Autowired
    ProductImpl productImpl;

    @GetMapping({"/","home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productImpl.getAllProduct());
        model.addAttribute("categories",categoryImpl.getAllCategories());

        System.out.println(GlobalData.cart.size());
        return "index";
    }

    @PostMapping("/home")
    public String home1(){
        return "index";
    }

    @GetMapping("/home/category/{id}")
    public String getProductsByCategoryId(Model model, @PathVariable("id") int id){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productImpl.findAllProductsByCategoryId(id));
        model.addAttribute("categories",categoryImpl.getAllCategories());
        return "index";
    }

    @GetMapping("/bynow/{id}")
    public String byNow(@PathVariable("id") int id,Model model) throws ProductNotFoundException {
        model.addAttribute("totalPrice",productImpl.getProductById(id).getPrice());
        return "checkout";
    }
}
