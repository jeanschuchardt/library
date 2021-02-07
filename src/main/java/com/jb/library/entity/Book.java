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

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    //@GeneratedValue
//    @SequenceGenerator( name = "BOOK_ID", sequenceName = "BOOK_SEQ", allocationSize = 1 )
//    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "BOOK_ID" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private String title;
    private  int pageCount;

    //@OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
   // @JoinColumn(name = "book_fk", referencedColumnName = "id")
    @ManyToMany
    private  List<Author> authorList;

   // @OneToMany(targetEntity = Gener.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "gener_fk", referencedColumnName = "id")
    @ManyToMany
    private  List<Gener> genersList;

//    @ManyToMany(mappedBy = "books")
//    private List<LoanRecord> loadRecord;




}
