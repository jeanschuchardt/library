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

@Entity(name = "Gener")
@Table(name = "Gener")
public class Gener {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    //@Column(unique=true)
    String name;

    @ManyToMany(targetEntity = Book.class,mappedBy = "genersList")
    @JsonIgnore
    private Set<Book> bookList = new HashSet<>();


}
