package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.dto.CommentDto;
import lt.codeacademy.blog.entity.BlogUser;
import lt.codeacademy.blog.entity.Comment;
import lt.codeacademy.blog.entity.Post;
import lt.codeacademy.blog.exception.CommonException;
import lt.codeacademy.blog.exception.NotFoundException;
import lt.codeacademy.blog.service.BlogUserService;
import lt.codeacademy.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class CommentController {
    private final PostService postService;
    private final BlogUserService blogUserService;

    public CommentController(PostService postService, BlogUserService blogUserService) {
        this.postService = postService;
        this.blogUserService = blogUserService;
    }

    @PostMapping("/comment")
    public String newComment(
            @ModelAttribute("comment") CommentDto comment,
            Principal principal) {
        if (principal == null) {
            return "redirect:/main";
        }
        Post post = postService.getById(comment.getPostId()).orElseThrow(() -> new NotFoundException(comment.getPostId(), "notfound.post"));
        BlogUser blogUser = blogUserService.findByUserName(principal.getName()).orElseThrow(() -> new CommonException("common.error.user.not.found"));
        post.getComments().add(new Comment(comment.getComment(), LocalDate.now(), blogUser, post));
        postService.save(post);
        return "redirect:/post/" + comment.getPostId();
    }
}
