package com.jb.library.service;

import com.jb.library.entity.Book;
import com.jb.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book findById(int bookId) {
        return bookRepository.findById(bookId);
    }
}
