package com.jb.library.controller;

import com.jb.library.entity.BookBorrrower;
import com.jb.library.entity.LoanRecord;
import com.jb.library.entity.Record;
import com.jb.library.service.LoanRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanRecord")
public class LoanRecordController {

    @Autowired
    private LoanRecordService loanRecordService;

    @GetMapping("findAll")
    ResponseEntity<List<LoanRecord>> getAllRecords() {
        return new ResponseEntity<>(loanRecordService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addRecord")
    ResponseEntity<LoanRecord> create(@RequestBody Record record) throws Exception {
        return new ResponseEntity<>(loanRecordService.save(record.getBookid(), record.getBorrowerid()), HttpStatus.CREATED);
    }


    @GetMapping("/findByBookName")
    ResponseEntity<BookBorrrower> findBookName(@RequestParam String book) {
        return new ResponseEntity<>(loanRecordService.findByBooks(book), HttpStatus.OK);
    }

}
