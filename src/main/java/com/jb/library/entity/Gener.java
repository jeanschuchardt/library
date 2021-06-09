package com.jb.library.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gener")
public class Gener {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    //@Column(unique=true)
    @Column
    private String name;

    @ManyToMany(targetEntity = Book.class,mappedBy = "genersList")
    @JsonIgnore
    private Set<Book> bookList = new HashSet<>();


}
