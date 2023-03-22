package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.dto.UserDTO;
import com.perfios.bootcamp.ecomwebsite.exception.UserNotFoundException;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.UserServiceImpl;
import com.perfios.bootcamp.ecomwebsite.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    public static String email;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("user") User user) {
        System.out.println("Login Post method called!!");
        System.out.println("user: "+user);
        return "index";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmailId(userDTO.getEmailId());
        System.out.println("email: " + userDTO.getEmailId());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setRoles(userDTO.getRole());
        user.setMobileNumber(userDTO.getMobileNumber());
        userService.saveUser(user);
        return "login";
    }

    @GetMapping("forgotpassword")
    public String getForgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("forgotpassword")
    public String postForgotPassword(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("user",user);

        email = user.getEmailId();
//        System.out.println("email: " + email);

        String emailId = email;
        String emailSubject = "Reset Password";
        String returnAddress = "http://localhost:8080/resetpassword";
        String message = "<html>" +
                "<head><title>" + emailSubject + "</title></head>" +
                "<body>" +
                "Click <a href=\"" + returnAddress + "\">here</a> to reset password." +
                "</body>" +
                "</html>";
        EmailUtils.sendEmail(emailId, emailSubject, message);
        return "forgotPassword";
    }

    @GetMapping("resetpassword")
    public String getResetPassword(){
        return "resetPassword";
    }

    @PostMapping("resetpassword")
    public String postResetPassword(@ModelAttribute("user") User user) throws UserNotFoundException {
        if(email!=null) {
            User user1 = userService.getUserByEmailId(email);
            user1.setPassword(user.getPassword());
            userService.saveUser(user1);
            return "login";
        }
        return "resetPassword?failure";
    }
}



