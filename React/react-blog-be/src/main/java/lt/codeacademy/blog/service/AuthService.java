package lt.codeacademy.blog.service;

import lt.codeacademy.blog.dto.RegisterRequest;
import lt.codeacademy.blog.entity.BlogUser;
import lt.codeacademy.blog.repository.BlogUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final BlogUserRepository repository;

    public AuthService(BlogUserRepository repository) {
        this.repository = repository;
    }

    public boolean signup(RegisterRequest registerRequest) {
        BlogUser blogUser = new BlogUser(registerRequest);
        return repository.findByUserName(blogUser.getUserName())
                .map(user -> false)
                .orElseGet(() -> {
                    repository.save(blogUser);
                    return true;
                });
    }
}
