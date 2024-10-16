package dev.dario.bookmarks.repository;

import dev.dario.bookmarks.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

  List<Bookmark> findAllByOrderByCreatedAtDesc();

}
