package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogPostController {

    private final PostService postService;

    public BlogPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = {"/", "/main"})
    public String mainPage(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "main-templates/main-template";
    }

    @GetMapping(value = {"/post/{id}"})
    public String postPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "main-templates/post-template";
    }

}
