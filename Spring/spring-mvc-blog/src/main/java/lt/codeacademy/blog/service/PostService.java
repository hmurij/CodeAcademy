package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.Post;
import lt.codeacademy.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Post getById(Long id) {
        return repository.getById(id);
    }
}
