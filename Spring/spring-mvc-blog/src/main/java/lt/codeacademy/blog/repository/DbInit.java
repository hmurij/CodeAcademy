package lt.codeacademy.blog.repository;

import org.springframework.stereotype.Component;

@Component
public class DbInit {
    private final BlogUserRepository repository;

    public DbInit(BlogUserRepository repository) {
        this.repository = repository;
//        repository.saveAll(BlogFactory.blogUsers);
    }

//    @PostConstruct
//    private void intiDb() {
//        repository.saveAll(BlogFactory.blogUsers);
//    }
}
