package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lt.codeacademy.blog.dto.UserRequest;
import lt.codeacademy.blog.service.AuthService;
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
    public ResponseEntity<JsonNode> login(@RequestBody UserRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> signup(@RequestBody UserRequest userRequest) {
        return authService.signup(userRequest)
                ? ResponseEntity.ok(responseMessage("New user " + userRequest.getUserName() + " successfully created!"))
                : ResponseEntity.unprocessableEntity().body(responseMessage("Username " + userRequest.getUserName() + " already exists"));
    }

    private ObjectNode responseMessage(String message) {
        return new ObjectMapper().createObjectNode()
                .put("message", message);
    }
}
