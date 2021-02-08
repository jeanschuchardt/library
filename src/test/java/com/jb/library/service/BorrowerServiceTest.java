package com.jb.library.service;

import com.jb.library.entity.Borrower;
import com.jb.library.repository.BorrowerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BorrowerServiceTest {
    @Autowired
    private BorrowerRepository borrowerRepository;

    @AfterEach
    void tearDown() {
        borrowerRepository.deleteAll();
    }

    @Test
    void findAll() {

        List<Borrower> borrowerList = new ArrayList<>();

        borrowerList.add(Borrower.builder().borrowingLimit(10).firstName("Jhon").lastName("Smith").build());
        borrowerList.add(Borrower.builder().borrowingLimit(1).firstName("Robert").lastName("Smith").build());
        borrowerList.add(Borrower.builder().borrowingLimit(3).firstName("Brandon").lastName("Smith").build());

        for (Borrower b : borrowerList) {
            borrowerRepository.save(b);

        }

        BorrowerService borrowerService = new BorrowerService(borrowerRepository);
        List<Borrower> borrowerList2 = borrowerService.findAll();

        assertEquals(borrowerList.size(), borrowerList2.size());
    }

    @Test
    void save() {

        Borrower borrower = Borrower.builder().borrowingLimit(10).firstName("Jhon").lastName("Smith").build();
        borrowerRepository.save(borrower);
        assertEquals(1, borrowerRepository.count());

    }

}