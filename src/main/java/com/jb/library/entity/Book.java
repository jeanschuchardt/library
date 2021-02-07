package com.jb.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany (cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    private  Set<Author> authorList = new HashSet<>();

   // @OneToMany(targetEntity = Gener.class, cascade = CascadeType.ALL)
   // @OneToMany(targetEntity = Gener.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "gener_fk", referencedColumnName = "id")
    @ManyToMany(cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Gener> genersList = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private List<LoanRecord> loadRecord;




}
