package dev.dario.bookmarks.controller;

import dev.dario.bookmarks.dto.BookmarkDTO;
import dev.dario.bookmarks.record.CreateBookmarkCmd;
import dev.dario.bookmarks.service.BookmarkService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    ResponseEntity<BookmarkDTO> findBookmarkById(@PathVariable Long id) {
        var bookmar = bookmarkService.findBookmarkById(id);
        return bookmar.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Void> createBookmark(@RequestBody @Valid CreateBookmarkPayload payload) {
        CreateBookmarkCmd cmd = new CreateBookmarkCmd(payload.title(), payload.url(), 1L);
        Long id = bookmarkService.createBookmark(cmd);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(id);
        return ResponseEntity.created(uri).build();
    }

    record CreateBookmarkPayload(@NotEmpty String title, @NotEmpty String url) {


    }


}
