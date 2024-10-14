package dev.dario.bookmarks.repository;

import dev.dario.bookmarks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
