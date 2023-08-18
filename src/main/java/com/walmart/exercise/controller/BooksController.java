package com.walmart.exercise.controller;

import com.walmart.exercise.entity.Book;
import com.walmart.exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RequestMapping("books")
@RestController
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<?> getBooks(){
        return ResponseEntity.ok(service.getBook());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<?> getBookByIsbn(@PathVariable Long isbn){
        return ResponseEntity.ok(service.getBookByIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBook(book));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/autorName/{autorName}")
    public ResponseEntity<?> getBookByAutorName(@PathVariable String autorName){
        return ResponseEntity.ok(service.getBookByAutorName(autorName));
    }

    @GetMapping("/date")
    public ResponseEntity<?> getBookByAutorName(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date date){
        return ResponseEntity.ok(service.getBookByDate(date));
    }

}
