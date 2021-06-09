package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int number;
    @Column
    private String title;
    @Column
    private int pageCount;


    @ManyToMany(targetEntity = Author.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Author> authorList = new HashSet<>();

    @ManyToMany(targetEntity = Gender.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Gender> genersList = new HashSet<>();

    @OneToMany(mappedBy = "books")
    private Set<LoanRecord> loadRecord = new HashSet<>();


}
