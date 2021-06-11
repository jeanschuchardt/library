package com.jb.library.service;

import com.jb.library.entity.Book;
import com.jb.library.entity.Page;
import com.jb.library.repository.BookRepository;
import com.jb.library.repository.PageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class PageServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PageRepository pageRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_create_book_and_page() {

        Book book = Book.builder()

                .title("Test2")
                .number(1001)
                //.authorList(authorList)
                .pageCount(1000)
                .build();
        bookRepository.save(book);

//        BookService bookService = new BookService(bookRepository);


        pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
        pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
        pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));



    }
}