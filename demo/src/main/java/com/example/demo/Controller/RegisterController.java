package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired private UserService userService;

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/create")
    public String userRegister(Model model, @RequestParam("username") String name,
                               @RequestParam("hobby") String hobby,
                               @RequestParam("password") String pass,
                               @RequestParam("repassword") String repass){
        if(!pass.equals(repass)){
            model.addAttribute("message","Incorrect password");
            return "register";
        }
        for (User u : userService.listAll()){
            if(u.getUsername().equals(name)){
                model.addAttribute("message","Account existed!");
                return "register";
            }
        }
        userService.addUser(new User(name, pass, hobby));
        System.out.println(new User(name, pass, hobby));
        return "redirect:/";
    }
}
