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
    ResponseEntity<Borrower> findBorrowerByid(@RequestParam int id){
        return new ResponseEntity<>(borrowerService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/findByName")
    ResponseEntity<Borrower> findBorrowerByName(@RequestParam String firstName,@RequestParam String lastName){
        return new ResponseEntity<>(borrowerService.findByFirstNameAndLastName(firstName,lastName), HttpStatus.OK);
    }

    @PostMapping("/addBorrower")
    ResponseEntity<Borrower> create(@RequestBody Borrower borrower) {
        return new ResponseEntity<>(borrowerService.save(borrower), HttpStatus.CREATED);
    }
}
