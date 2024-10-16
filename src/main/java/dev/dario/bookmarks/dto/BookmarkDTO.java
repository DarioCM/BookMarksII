package dev.dario.bookmarks.dto;

import java.time.Instant;

/**
 * Projection for {@link dev.dario.bookmarks.entity.Bookmark}
 */
public interface BookmarkDTO {
    Integer getId();

    String getTitle();

    String getUrl();

    Instant getCreatedAt();

    UserDTO getUser();

    /**
     * Projection for {@link dev.dario.bookmarks.entity.User}
     */
    interface UserDTO {
        Integer getId();

        String getName();
    }
}
