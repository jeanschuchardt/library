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

@Entity(name = "Gener")
@Table(name = "bener")
public class Gener {
    @Id
    @GeneratedValue
    private Long id;
    String name;

}
