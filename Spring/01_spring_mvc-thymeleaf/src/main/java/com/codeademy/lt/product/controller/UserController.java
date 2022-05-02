package com.codeademy.lt.product.controller;

import com.codeademy.lt.product.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PostMapping("/user")
    public String createNewUser(@ModelAttribute("product") UserDto userDto) {
        System.out.println(userDto);
        return "redirect:/user";
    }
}
