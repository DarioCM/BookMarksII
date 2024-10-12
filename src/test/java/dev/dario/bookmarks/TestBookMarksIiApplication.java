package dev.dario.bookmarks;

import org.springframework.boot.SpringApplication;

public class TestBookMarksIiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookMarksIiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
