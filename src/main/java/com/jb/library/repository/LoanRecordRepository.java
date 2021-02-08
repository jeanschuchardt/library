package com.jb.library.repository;

import com.jb.library.entity.Book;
import com.jb.library.entity.Borrower;
import com.jb.library.entity.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loanRecordRepository")
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {

    LoanRecord findByid(Long id);

    List<LoanRecord> findByBooks(Book book);

    List<LoanRecord> findByBorrowers(Borrower borrower);
}
