package com.codeademy.lt.product.controller;

import com.codeademy.lt.product.model.Product;
import com.codeademy.lt.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/open")
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("products/open")
    public String createProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("quantity"));
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("description"));

        productService.addProduct(product);

        return "product";
    }
}
