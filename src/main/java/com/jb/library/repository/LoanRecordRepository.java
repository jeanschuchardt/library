package com.jb.library.repository;

import com.jb.library.entity.Borrower;
import com.jb.library.entity.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("loanRecordRepository")
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {

    Borrower findByid(Long id);
}
