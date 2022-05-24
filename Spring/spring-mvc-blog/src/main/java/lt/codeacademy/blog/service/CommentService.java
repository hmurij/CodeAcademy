package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.Comment;

import java.util.Optional;

public interface CommentService {
    Optional<Comment> findById(Long id);
}
