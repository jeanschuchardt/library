package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Author")
@Table(name = "author")
@JsonIgnoreProperties("bookList")
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    String firstName;
    String lastName;

    @ManyToMany(mappedBy = "authorList")
    private Set<Book> bookList =  new HashSet<>();

    @Override
    public String toString() {
        return "Author{" +
                "firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                '}';
    }
}
