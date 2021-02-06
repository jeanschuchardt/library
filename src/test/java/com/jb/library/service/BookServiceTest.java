package com.jb.library.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jb.library.entity.Book;
import com.jb.library.repository.BookRepository;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @AfterEach
    void tearDown(){
        bookRepository.deleteAll();
    }

    @Test
    void getAllBooks() {
        Book bookSample = Book.builder()
                .title("Test2")
                .number(1001)
                .build();
        bookRepository.save(bookSample);
        BookService bookService =  new BookService(bookRepository);

        List<Book> bookList  = bookService.findAll();
        Book lastBook = bookList.get(bookList.size()-1);

        assertEquals(bookSample.getTitle(),lastBook.getTitle());
        assertEquals(bookSample.getNumber(),lastBook.getNumber());

    }

    @Test
    void saveBook() {
        BookService toDoService = new BookService(bookRepository);
        Book todoSample = Book.builder()
                .title("Test2")
                .number(1001)
                .build();

        toDoService.save(todoSample);

        assertEquals(1.0, bookRepository.count());
    }



}