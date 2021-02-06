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
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private  List<Author> authorList;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true//,
            //fetch = FetchType.EAGER
    )
    private  List<Gener> genersList;
//



}
