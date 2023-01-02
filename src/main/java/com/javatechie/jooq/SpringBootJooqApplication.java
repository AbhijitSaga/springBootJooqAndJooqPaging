package com.javatechie.jooq;

import com.javatechie.jooq.service.BookService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication(exclude = { R2dbcAutoConfiguration.class })
//@SpringBootApplication
@RestController
//@RequestMapping("/my/books")
public class SpringBootJooqApplication {

	@Autowired
	private BookService service;

	@PostMapping("/books")
	public ResponseEntity<?> addBook(@RequestBody Book book) {

		return service.insertBook(book);

	}

	@GetMapping("/books")
	public ResponseEntity<?> getBooks(@RequestParam Integer size, @RequestParam Integer page) {
		return service.getBooksPage(size, page);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJooqApplication.class, args);

	}

}
