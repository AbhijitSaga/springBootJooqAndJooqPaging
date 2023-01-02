package com.javatechie.jooq.service;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.jooq.impl.DSL.*;

import com.javatechie.jooq.dto.BookDto;
import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;

import java.util.List;

@Service
public class BookService {

	@Autowired
	private DSLContext dslContext;

	public ResponseEntity<Object> insertBook(Book book) {
		var result=0;
		try {
		result=		dslContext.insertInto(Tables.BOOK, Tables.BOOK.ID, Tables.BOOK.TITLE, Tables.BOOK.AUTHOR)
					.values(book.getId(), book.getTitle(), book.getAuthor()).execute();
		} catch (Exception e) {

			e.getStackTrace();
		}
		return ResponseEntity.ok(result);
	}

	
	public ResponseEntity<?> getBooksPage(Integer size, Integer page) {

		List<BookDto> result = null;
		Field<Integer> totalRows = count().over().as("total_rows");
		Field<Integer> row = rowNumber().over().orderBy(Tables.BOOK.ID.as("id")).as("row");
		Field<?> id = field("id");

		try {
			Table<?> booktable = select(Tables.BOOK.ID.as("id"), Tables.BOOK.TITLE, Tables.BOOK.AUTHOR)
					.from(Tables.BOOK).orderBy(Tables.BOOK.ID).asTable("booktable");

			Table<?> book_page = select(booktable.asterisk()).select(row, totalRows).from(booktable).limit(size)
					.offset(page * size).asTable("book_page");

			result = dslContext.select(book_page.asterisk())
					.select(book_page.field(totalRows).minus(inline(1)).div(size).plus(inline(1)).as("total_page"),
							book_page.field(row).minus(inline(1)).div(size).plus(inline(1)).as("current_page"),
							field(max(book_page.field(row)).over().eq(book_page.field(totalRows))).as("last_page"))
					.from(book_page).fetchInto(BookDto.class);

		} catch (Exception e) {
			System.out.println("during book date get");
			e.getStackTrace();
		}

		return ResponseEntity.ok(result);
	}
}
