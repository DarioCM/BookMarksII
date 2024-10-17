package dev.dario.bookmarks.record;

public record CreateBookmarkCmd(String title, String url, Long userId) {
}
