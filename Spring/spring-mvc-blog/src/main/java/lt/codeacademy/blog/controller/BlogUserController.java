package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.service.BlogUserService;
import org.springframework.stereotype.Controller;

@Controller
public class BlogUserController {
    private BlogUserService userService;

    public BlogUserController(BlogUserService userService) {
        this.userService = userService;
    }
}
