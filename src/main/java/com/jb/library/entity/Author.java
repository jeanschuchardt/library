package com.jb.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Author")
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    String firstName;
    String lastName;

}
