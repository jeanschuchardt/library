package com.jb.library.repository;

import com.jb.library.entity.Book;
import com.jb.library.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("borrowerRepository")
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    public Borrower findByid(Long id);

}
