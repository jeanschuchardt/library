package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String title;
    private  int pageCount;


    @ManyToMany (targetEntity = Author.class, cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    private  Set<Author> authorList = new HashSet<>();


    @ManyToMany(targetEntity = Gener.class, cascade =  {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Gener> genersList = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<LoanRecord> loadRecord =  new HashSet<>();


}
