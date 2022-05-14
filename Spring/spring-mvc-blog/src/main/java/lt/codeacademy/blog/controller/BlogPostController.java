package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogPostController {

    private final PostRepository postRepository;

    public BlogPostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "main-page/main-page";
    }

}
