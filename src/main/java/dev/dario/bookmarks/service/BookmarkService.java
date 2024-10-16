package dev.dario.bookmarks.service;

import dev.dario.bookmarks.entity.Bookmark;
import dev.dario.bookmarks.repository.BookmarkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookmarkService {


    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public List<Bookmark> finAll(){
        return bookmarkRepository.getAllByCreatedAtDesc();
    }

}
