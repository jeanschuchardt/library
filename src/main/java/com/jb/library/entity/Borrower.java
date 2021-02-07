package com.jb.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Borrower")
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int Long;
    String firstName;
    String lastName;

    int borrowingLimit = 3;


}
