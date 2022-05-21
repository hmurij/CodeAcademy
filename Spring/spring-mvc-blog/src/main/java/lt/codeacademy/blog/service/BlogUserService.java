package lt.codeacademy.blog.service;

import lt.codeacademy.blog.dto.BlogUserDto;
import lt.codeacademy.blog.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    List<BlogUser> findAll();

    void save(BlogUserDto blogUserDto);

    boolean findByUserName(String userName);
}
