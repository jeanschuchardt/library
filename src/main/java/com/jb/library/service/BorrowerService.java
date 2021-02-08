package com.jb.library.service;


import com.jb.library.entity.Borrower;

import com.jb.library.repository.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {

    private BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> findAll(){ return borrowerRepository.findAll();    }

    public Borrower save(Borrower borrower){
        return borrowerRepository.save(borrower);
    }


    public Borrower findByFirstNameAndLastName(String firstName, String lastName) {return borrowerRepository.findByFirstNameAndLastName(firstName,lastName);    }

    public Borrower findById(int borrowerId) { return borrowerRepository.findById(borrowerId);    }
}
