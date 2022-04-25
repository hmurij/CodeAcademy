package com.codeademy.lt.product.controller;

import com.codeademy.lt.product.model.Product;
import com.codeademy.lt.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", Product.builder().build());
        return "product";
    }

    @PostMapping
    public String createProduct(@ModelAttribute("product") Product product, Model model /*, HttpServletRequest request */) {
        productService.save(product);
        model.addAttribute("message", "Product added successfully");
        return "product";
    }

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/update")
    public String getUpdateProduct(@RequestParam("id") UUID uuid, Model model) {
        model.addAttribute("product", productService.getProductByUuid(uuid));
        return "product";
    }

    @PostMapping("/update")
    public String getUpdateProduct(Model model, Product product) {
        productService.updateProduct(product);
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("id") UUID id) {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }

}
