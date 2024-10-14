package dev.dario.bookmarks.repository;

import dev.dario.bookmarks.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

  List<Bookmark> getAllByCreatedAtDesc();

}
