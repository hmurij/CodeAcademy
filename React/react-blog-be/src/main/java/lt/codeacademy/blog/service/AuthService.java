package lt.codeacademy.blog.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lt.codeacademy.blog.dto.LoginRequest;
import lt.codeacademy.blog.dto.RegisterRequest;
import lt.codeacademy.blog.entity.BlogUser;
import lt.codeacademy.blog.repository.BlogUserRepository;
import lt.codeacademy.blog.security.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final BlogUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AuthService(
            BlogUserRepository repository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtProvider jwtProvider
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public boolean signup(RegisterRequest registerRequest) {
        BlogUser blogUser = this.mapToBlogUser(registerRequest);
        return repository.findByUserName(blogUser.getUserName())
                .map(user -> false)
                .orElseGet(() -> {
                    repository.save(blogUser);
                    return true;
                });
    }

    private BlogUser mapToBlogUser(RegisterRequest registerRequest) {
        return new BlogUser(
                registerRequest.getUserName(),
                "USER",
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getEmail()
        );
    }

    public ResponseEntity<JsonNode> login(LoginRequest loginRequest) {
        Authentication authenticate;
        ObjectNode loginResponse = new ObjectMapper().createObjectNode();
        try {
            authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            loginResponse = loginResponse(authenticate);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(loginResponse.put("error", e.getMessage()));
        }
        return ResponseEntity.ok(loginResponse);
    }

    private ObjectNode loginResponse(Authentication authenticate) {
        return new ObjectMapper().createObjectNode()
                .put("userName", authenticate.getName())
                .put("authorities", authorities(authenticate.getAuthorities()))
                .put("jwt", jwtProvider.generateToken(authenticate));
    }

    private String authorities(Collection<? extends GrantedAuthority> grantedAuthority) {
        return grantedAuthority.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public Optional<User> getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
