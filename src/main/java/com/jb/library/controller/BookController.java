package com.jb.library.controller;

import com.jb.library.entity.Book;
import com.jb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity <> (bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByTitle")
    ResponseEntity<Book> findBookByTitle(@RequestParam String title){
        return new ResponseEntity <> (bookService.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping("/addBook")
    ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

}
