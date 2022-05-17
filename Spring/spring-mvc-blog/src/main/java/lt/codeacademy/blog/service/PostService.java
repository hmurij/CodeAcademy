package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> findAll();

    public Optional<Post> getById(Long id);
}
