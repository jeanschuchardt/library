package com.jb.library.service;

import com.jb.library.entity.Borrower;
import com.jb.library.entity.LoanRecord;
import com.jb.library.repository.LoanRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRecordService {
    @Autowired
    private LoanRecordRepository    loanRecordRepository;

    public LoanRecordService(LoanRecordRepository loanRecordRepository) {
        this.loanRecordRepository = loanRecordRepository;
    }

    public List<LoanRecord> findAll(){ return loanRecordRepository.findAll();    }

    public LoanRecord save(LoanRecord loanRecord){
        return loanRecordRepository.save(loanRecord);
    }

    public Borrower findByID(Long id) { return loanRecordRepository.findByid(id);   }



/*
    Create a loan record for a given book/borrower
* Get a list of past borrowers for a book
* Get a list of past books borrowed by a given borrower
*/
}
