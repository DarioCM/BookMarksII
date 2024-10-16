package dev.dario.bookmarks.controller;

import dev.dario.bookmarks.dto.BookmarkDTO;
import dev.dario.bookmarks.entity.Bookmark;
import dev.dario.bookmarks.service.BookmarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {


    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    List<BookmarkDTO> findAll() {
        return bookmarkService.finAll();
    }


}
