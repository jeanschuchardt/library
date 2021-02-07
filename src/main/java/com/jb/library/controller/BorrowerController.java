package com.jb.library.controller;

import com.jb.library.entity.Borrower;
import com.jb.library.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping("/findAll")
    ResponseEntity<List<Borrower>> getAllBorrowers(){
        return new ResponseEntity<>(borrowerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByID")
    ResponseEntity<Borrower> findBorrowerByid(@RequestParam Long id){
        return new ResponseEntity<>(borrowerService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("/addBook")
    ResponseEntity<Borrower> create(@RequestBody Borrower borrower) {
        return new ResponseEntity<>(borrowerService.save(borrower), HttpStatus.CREATED);
    }
}
