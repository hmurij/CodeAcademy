package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lt.codeacademy.blog.entity.Post;
import lt.codeacademy.blog.repository.PostRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JsonNode> getPosts() {
        return postRepository.findAll().stream()
                .map(Post::asJson)
                .toList();
    }
}
