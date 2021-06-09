package com.jb.library.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan_record")
public class LoanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_fk", referencedColumnName = "id")
    private Book books;


    @ManyToOne(targetEntity = Borrower.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_fk", referencedColumnName = "id")
    private Borrower borrowers;

}
