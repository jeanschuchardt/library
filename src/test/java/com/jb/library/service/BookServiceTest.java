package com.jb.library.service;

import com.jb.library.entity.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jb.library.entity.Book;
import com.jb.library.repository.BookRepository;


import java.util.ArrayList;
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
    void findAllBooks() {
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);

        Book bookSample = Book.builder()
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
        assertEquals(bookSample.getAuthorList().toString(),lastBook.getAuthorList().toString());

    }

    @Test
    void findBookByTitle() {
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);

        Book bookSample = Book.builder()
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
        assertEquals(bookSample.getAuthorList().toString(),lastBook.getAuthorList().toString());

    }

    @Test
    void saveBook() {
        BookService bookService = new BookService(bookRepository);
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);

        Book todoSample = Book.builder()
                .title("Test2")
                .number(1001)
                .authorList(authorList)
                .pageCount(1000)
                .build();

        bookService.save(todoSample);

        assertEquals(1.0, bookRepository.count());
    }



}
