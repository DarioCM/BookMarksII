package dev.dario.bookmarks.service;

import dev.dario.bookmarks.dto.BookmarkDTO;
import dev.dario.bookmarks.entity.Bookmark;
import dev.dario.bookmarks.record.CreateBookmarkCmd;
import dev.dario.bookmarks.repository.BookmarkRepository;
import dev.dario.bookmarks.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookmarkService {


    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository, UserRepository userRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.userRepository = userRepository;
    }

    @Cacheable
    public List<BookmarkDTO> finAll(){
        return bookmarkRepository.findAllByOrderByCreatedAtDesc();
    }

    @Cacheable
    public Optional<BookmarkDTO> findBookmarkById(Long id) {
        return bookmarkRepository.findBookmarkById(id);
    }

    public Long createBookmark(CreateBookmarkCmd cmd) {
        var bookmark = new Bookmark();
        bookmark.setTitle(cmd.title());
        bookmark.setUrl(cmd.url());
        bookmark.setUser(userRepository.getReferenceById(cmd.userId()));
        bookmark.setCreatedAt(Instant.now());
        bookmarkRepository.save(bookmark);
        return  bookmark.getId();
    }

}
