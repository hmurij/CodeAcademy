package com.codeademy.lt.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public String createCart() {
        return "default session cart value";
    }

    @GetMapping
    public String openCart(@ModelAttribute("cart") String cartValue, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String cartSessionObjectValue = (String) request.getSession().getAttribute("cart");
        model.addAttribute("cartValue", cartSessionObjectValue);
        return "cart";
    }

    @GetMapping("/add")
    public String addToCart(Model model) {
        model.addAttribute("cart", "testSessionAttribute");
        return "redirect:/cart";
    }
}
