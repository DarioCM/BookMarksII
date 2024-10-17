package dev.dario.bookmarks.repository;

import dev.dario.bookmarks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getReferenceById(Long aLong);
}
