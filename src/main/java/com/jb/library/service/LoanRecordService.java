package com.jb.library.service;

import com.jb.library.dto.BookBorrrower;
import com.jb.library.dto.BorrowerBooks;
import com.jb.library.entity.Book;
import com.jb.library.entity.Borrower;
import com.jb.library.entity.LoanRecord;
import com.jb.library.repository.LoanRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LoanRecordService {
    @Autowired
    private LoanRecordRepository loanRecordRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowerService borrowerService;

    public LoanRecordService(LoanRecordRepository loanRecordRepository) {
        this.loanRecordRepository = loanRecordRepository;
    }

    public BookBorrrower findByBooks(String book) {
        Book byTitle = bookService.findByTitle(book);
        List<LoanRecord> temp = loanRecordRepository.findByBooks(byTitle);
        List<Borrower> temp2 = new ArrayList<>();
        for (LoanRecord t : temp) {
            temp2.add(t.getBorrowers());
        }
        BookBorrrower bookBorrrower = BookBorrrower.builder()
                .title(byTitle.getTitle())
                .borrowerList(temp2)
                .build();

        return bookBorrrower;
    }


    public List<LoanRecord> findAll() {
        return loanRecordRepository.findAll();
    }

    public LoanRecord save(LoanRecord loanRecord) {
        return loanRecordRepository.save(loanRecord);
    }

    public LoanRecord findByID(Long id) {

        return loanRecordRepository.findByid(id);
    }

    public LoanRecord save(int bookId, int borrowerID) throws Exception {

        Book b = bookService.findById(bookId);
        Borrower bw = borrowerService.findById(borrowerID);

        if (b == null) {
            throw new Exception();
        }
        if (bw == null) {
            throw new Exception();
        }
        LoanRecord temp = LoanRecord.builder()
                .books(bookService.findById(bookId))
                .borrowers(borrowerService.findById(borrowerID))
                .build();
        return loanRecordRepository.save(temp);
    }

    public BorrowerBooks findByName(String fullName) throws Exception {

        Borrower borrower = borrowerService.findByFullName(fullName);
        List<LoanRecord> temp = loanRecordRepository.findByBorrowers(borrower);

        HashMap<Integer, String> books = new HashMap<>();

        for (LoanRecord t : temp) {
            books.put(t.getBooks().getId(), t.getBooks().getTitle());
        }

        BorrowerBooks borrowerBooks = BorrowerBooks.builder()
                .fullName(borrower.getFullName())
                .book(books)
                .build();

        return borrowerBooks;
    }
}
