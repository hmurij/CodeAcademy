package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.Comment;
import lt.codeacademy.blog.repository.CommentRepository;

import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return repository.findById(id);
    }
}
