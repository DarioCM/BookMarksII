package dev.dario.bookmarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookMarksIiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarksIiApplication.class, args);
    }

}
