package lt.codeacademy.blog.service;

import lt.codeacademy.blog.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    List<BlogUser> findAll();
}
