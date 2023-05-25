package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired private UserService userService;

    @GetMapping("/home")
    public String userList(Model model){
        List<User> userList = userService.listAll();
        model.addAttribute("userList",userList);
        return "home";
    }

}
