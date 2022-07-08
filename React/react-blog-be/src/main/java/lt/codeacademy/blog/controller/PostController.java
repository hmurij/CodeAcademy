package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lt.codeacademy.blog.entity.Post;
import lt.codeacademy.blog.repository.PostRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<JsonNode>> posts() {
        return ResponseEntity.ok(
                postRepository.findAll().stream()
                        .map(Post::asJson)
                        .toList()
        );
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> post(@PathVariable Long id) {
        return postRepository.findById(id)
                .map(Post::asJsonWithComments)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
