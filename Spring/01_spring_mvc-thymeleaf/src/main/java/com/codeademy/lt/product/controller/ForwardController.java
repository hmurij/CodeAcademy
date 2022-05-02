package com.codeademy.lt.product.controller;

import com.codeademy.lt.product.model.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForwardController {
    @GetMapping("/forwardExample")
    public String redirectExample(Model model) {
        model.addAttribute("product", new ProductDto());
        return "redirectExample";
    }

    @PostMapping("/forwardExample")
    public String createProduct(@ModelAttribute("product") ProductDto product, Model model /*, HttpServletRequest request */) {
        model.addAttribute("message", "Product added successfully");
        // save product to db
        return "forward:/secondforwardExample";
    }

    @PostMapping("/secondforwardExample")
    public String secondRedirectExample(Model model, ProductDto product) {
        model.addAttribute("product", product);
        return "redirectExample";
    }
}
