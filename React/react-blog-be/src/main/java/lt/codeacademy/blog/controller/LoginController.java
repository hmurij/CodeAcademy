package lt.codeacademy.blog.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> login(@RequestBody JsonNode user) {
        return ResponseEntity.ok().build();
    }
}
