package lt.codeacademy.blog.utils.mapper;

import lt.codeacademy.blog.dto.BlogUserDto;
import lt.codeacademy.blog.entity.BlogUser;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class BlogUserMapper {
    public static BlogUser mapToBlogUser(BlogUserDto blogUserDto) {
        return new BlogUser(blogUserDto.getUsername(), "USER", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(blogUserDto.getPassword()), blogUserDto.getEmail());
    }
}
