package com.jb.library.service;

import com.jb.library.entity.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jb.library.entity.Book;
import com.jb.library.repository.BookRepository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    void findAllBooks() {
        Author a  =  Author.builder().firstName("Roberto").lastName("Petri").build();
        Author b  =  Author.builder().firstName("Emanuel").lastName("Silva").build();
        Set<Author> authorList = new HashSet<>();
        authorList.add(a);
        authorList.add(b);

        Book bookSample = Book.builder()
                .id(100)
                .title("Test2")
                .number(1001)
                .authorList(authorList)
                .pageCount(1000)
                .build();
        bookRepository.save(bookSample);
        BookService bookService =  new BookService(bookRepository);

        List<Book> bookList  = bookService.findAll();
        Book lastBook = bookList.get(bookList.size()-1);

        assertEquals(bookSample.getTitle(),lastBook.getTitle());
        assertEquals(bookSample.getNumber(),lastBook.getNumber());


    }

    @Test
    void findBookByTitle() {
        Author a  =  Author.builder().firstName("Anna").lastName("Pet").build();
        Author b  =  Author.builder().firstName("Rafael").lastName("Carvalho").build();
        Set<Author> authorList = new HashSet<>();
        authorList.add(a);
        authorList.add(b);

        Book bookSample = Book.builder()
                .id(1000)
                .title("my book")
                .number(1001)
                .authorList(authorList)
                .pageCount(1000)
                .build();
        bookRepository.save(bookSample);
        BookService bookService =  new BookService(bookRepository);

        Book lastBook  = bookService.findByTitle("my book");

        assertEquals(bookSample.getTitle(),lastBook.getTitle());
        assertEquals(bookSample.getNumber(),lastBook.getNumber());


    }

    @Test
    void saveBook() {
        BookService bookService = new BookService(bookRepository);
        Author a  =  Author.builder().firstName("Roberto").lastName("Petri").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        Set<Author> authorList = new HashSet<>();
        authorList.add(a);
        authorList.add(b);

        Book todoSample = Book.builder()
                .id(101)
                .title("Test2")
                .number(1001)
                .authorList(authorList)
                .pageCount(1000)
                .build();

        bookService.save(todoSample);

        assertEquals(1.0, bookRepository.count());
    }



}
