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
    @GeneratedValue
    private Long id;
    private int number;
    private String title;
    private  int pageCount;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private  List<Author> authorList;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private  List<Gener> genersList;
//
//    private  String  authors;
//    private  String geners;


}
