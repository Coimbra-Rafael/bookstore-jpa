package com.bookstrore.jpa.controllers;

import com.bookstrore.jpa.dtos.BookRecordDto;
import com.bookstrore.jpa.models.BookModel;
import com.bookstrore.jpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getAllBooks());
    }

    @GetMapping("/id")
    public ResponseEntity<BookModel> getBookById(@RequestHeader UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getFindById(id));
    }

    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody BookRecordDto bookRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.saveBook(bookRecordDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestHeader UUID id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }
}
