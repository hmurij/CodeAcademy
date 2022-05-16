package com.codeademy.lt;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

//@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public String productNotFound(NotFoundException e, Model model) {
        model.addAttribute("productId", e.getProductId());
        return "productNotFound";
    }

    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }
}
