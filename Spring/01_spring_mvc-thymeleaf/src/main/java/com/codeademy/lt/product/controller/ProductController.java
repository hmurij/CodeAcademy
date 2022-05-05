package com.codeademy.lt.product.controller;

import com.codeademy.lt.helper.MessageService;
import com.codeademy.lt.product.model.ProductDto;
import com.codeademy.lt.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private final MessageService messageService;


//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping
    public String openCreateProductForm(Model model, String message) {
        model.addAttribute("product", ProductDto.builder().build());
        model.addAttribute("message", messageService.getMessage(message));
        return "product";
    }

    @PostMapping
    public String createProduct(@ModelAttribute("product") ProductDto product, Model model /*, HttpServletRequest request */) {
        productService.save(product);
        model.addAttribute("message", "Product added successfully");
        return "redirect:/products?message=create.product.message";
    }

    @GetMapping("/list")
    public String getAllProducts(Model model, @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("products", productService.getProducts(pageable));
        return "products";
    }

    @GetMapping("/update")
//    @GetMapping("/{productId}/update")
    public String getUpdateProduct(@RequestParam("id") UUID uuid, Model model) {
        model.addAttribute("product", productService.getProductByUuid(uuid));
        return "product";
    }

    @PostMapping("/update")
    public String getUpdateProduct(Model model, ProductDto product) {
        productService.updateProduct(product);
        model.addAttribute("products", productService.getProducts());
        return "redirect:/products/list";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("id") UUID id) {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }

//    @ExceptionHandler(NotFoundException.class)
//    public String productNotFound(NotFoundException e, Model model) {
//        model.addAttribute("productId", e.getProductId());
//        return "productNotFound";
//    }
}
