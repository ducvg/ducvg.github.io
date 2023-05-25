package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {
    @Autowired private UserService userService;

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        User u = userService.getUserById(id);
        model.addAttribute("user",u);
        return "edit";
    }

    @PostMapping("/edit/update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return "redirect:/home";
    }
}
