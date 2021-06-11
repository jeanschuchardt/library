package com.jb.library.controller;

import com.jb.library.entity.Book;
import com.jb.library.entity.Page;
import com.jb.library.repository.BookRepository;
import com.jb.library.repository.PageRepository;
import com.jb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PageRepository pageRepository;

    @GetMapping("/createe")
    ResponseEntity<List<Book>> create(){


        Book book = Book.builder()

                .title("Test2")
                .number(1001)
                //.authorList(authorList)
                .pageCount(1000)
                .build();
        Book save = bookRepository.save(book);

//        BookService bookService = new BookService(bookRepository);


        pageRepository.save(new Page(1, "Introduction contents", "Introduction", save));
        pageRepository.save(new Page(65, "Java 8 contents", "Java 8", save));
        pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", save));


        return new ResponseEntity <> (bookService.findAll(), HttpStatus.OK);
    }

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
