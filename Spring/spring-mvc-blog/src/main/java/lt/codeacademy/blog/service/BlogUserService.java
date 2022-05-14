package lt.codeacademy.blog.service;

import lt.codeacademy.blog.repository.BlogUserRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogUserService {
    private final BlogUserRepository repository;

    public BlogUserService(BlogUserRepository repository) {
        this.repository = repository;
    }

//    @PostConstruct
//    public void init() {
//        repository.deleteAll(repository.findAll());
//        BlogFactory.blogUsers.forEach(repository::save);
//    }

}
