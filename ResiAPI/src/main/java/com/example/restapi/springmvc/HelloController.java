package com.example.restapi.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {

        @RequestMapping("/homepage")
        public String redirect(){
        System.out.println("Home servlet called!!");
            return "home";
        }

        @RequestMapping("/login")
        public String login(){
            return "userlogin";
        }

        @RequestMapping("/register")
        public String register(){
            return "userregister";
        }

        @GetMapping("/submit")
        public String loginServlet(HttpServletRequest request, Model model){

            String useName = request.getParameter("user-name");
            String password = request.getParameter("password");

            User user = new User();

            user.setUserName(useName);
            user.setPassword(password);

            model.addAttribute("user",user);
            return "loginsuccess";
        }

        @GetMapping("/regsubmit")
        public String userRegSubmit(HttpServletRequest request, Model model){

            String funame = request.getParameter("fname");
            String userName = request.getParameter("user-name");
            String password = request.getParameter("password");

            User user = new User();

            user.setFullName(funame);
            user.setUserName(userName);
            user.setPassword(password);

            model.addAttribute("user",user);

            return "regsuccess";
        }

}
