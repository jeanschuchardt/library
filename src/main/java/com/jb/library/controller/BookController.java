package com.jb.library.controller;

import com.jb.library.entity.Book;

import com.jb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books/findAll")
    ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity <> (bookService.findAll(), HttpStatus.OK);
    }



}
