package com.jb.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "LoanRecord")
@Table(name = "loan_record")
public class LoanRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_fk", referencedColumnName = "id")
    private List<Book> books;


    @ManyToOne(targetEntity = Borrower.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_fk", referencedColumnName = "id")
    private List<Borrower> borrowers;



}
