package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.beans.Product;
import com.perfios.bootcamp.ecomwebsite.exception.ProductNotFoundException;
import com.perfios.bootcamp.ecomwebsite.global.GlobalData;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductImpl productService;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") int id) throws ProductNotFoundException {
        GlobalData.cart.add(productService.getProductById(id));
        return "redirect:/home";
    }


    @GetMapping("")
    public String cartGet(Model model){
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("totalPrice",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }

    @GetMapping("/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("totalPrice",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
}
