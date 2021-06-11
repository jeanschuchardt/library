package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@Data

@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int number;
    @Column
    private String title;
    @Column
    private int pageCount;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Page> pages;


//    @ManyToMany(targetEntity = Author.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Author> authorList = new HashSet<>();
//
//    @ManyToMany(targetEntity = Gender.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JsonIgnore
//    private Set<Gender> genersList = new HashSet<>();
//
//    @OneToMany(mappedBy = "books")
//    @JsonIgnore
//    private Set<LoanRecord> loadRecord = new HashSet<>();


}

