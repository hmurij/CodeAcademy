package lt.codeacademy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogPostController {

    @GetMapping
    public String mainPage(Model model) {
        return "main-page/main-page";
    }
}
