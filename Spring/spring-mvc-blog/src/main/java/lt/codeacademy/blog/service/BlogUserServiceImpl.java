package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.BlogUser;
import lt.codeacademy.blog.repository.BlogUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogUserServiceImpl implements BlogUserService {

    private final BlogUserRepository repository;

    public BlogUserServiceImpl(BlogUserRepository repository) {
        this.repository = repository;
    }

//    @PostConstruct
//    public void init() {
//        BlogFactory.blogUsers.forEach(repository::save);
//        repository.save(BlogFactory.generateBlogAdmin());
//    }

    @Override
    public List<BlogUser> findAll() {
        return repository.findAll();
    }
}
