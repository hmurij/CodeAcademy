package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lt.codeacademy.blog.dto.NewPostRequest;
import lt.codeacademy.blog.entity.Post;
import lt.codeacademy.blog.repository.BlogUserRepository;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostRepository postRepository;
    private final AuthService authService;

    public PostController(
            PostRepository postRepository,
            BlogUserRepository blogUserRepository,
            AuthService authService
    ) {
        this.postRepository = postRepository;
        this.authService = authService;
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

    @PostMapping(value = "/posts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<JsonNode> createPost(@RequestBody NewPostRequest newPostRequest) {
        return ResponseEntity.ok(postRepository.save(newPost(newPostRequest)).asJson());
    }

    private Post newPost(NewPostRequest newPostRequest) {
        return new Post(
                newPostRequest.getTitle(),
                newPostRequest.getContent(),
                LocalDate.now(),
                LocalDate.now(),
                authService.getBlogUser().orElseThrow(),
                new ArrayList<>()
        );
    }
}
