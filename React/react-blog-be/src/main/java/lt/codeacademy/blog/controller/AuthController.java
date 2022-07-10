package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.codeacademy.blog.dto.RegisterRequest;
import lt.codeacademy.blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> login(@RequestBody JsonNode user) {
        return ResponseEntity.ok(new ObjectMapper().createObjectNode().put("message", "You're logged in!"));
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> signup(@RequestBody RegisterRequest registerRequest) {
        return authService.signup(registerRequest)
                ? ResponseEntity.ok().build()
                : ResponseEntity.unprocessableEntity().build();
    }
}
