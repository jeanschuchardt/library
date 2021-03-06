package com.jb.library.repository;

import com.jb.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book findByTitle(String title);
    public Book findById(int bookId);
}
