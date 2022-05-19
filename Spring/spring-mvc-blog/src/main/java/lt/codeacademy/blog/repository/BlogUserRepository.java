package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {

}
