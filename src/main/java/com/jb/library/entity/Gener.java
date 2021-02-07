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

@Entity(name = "Gener")
@Table(name = "Gener")
public class Gener {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    String name;

    @ManyToMany(mappedBy = "genersList")
    private List<Book> bookList;


}
