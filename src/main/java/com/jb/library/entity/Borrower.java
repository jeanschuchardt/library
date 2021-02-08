package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Borrower")
@Table(name = "borrower",uniqueConstraints={@UniqueConstraint(columnNames = {"firstName" , "lastName"})})
public class Borrower {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String firstName;
    String lastName;

    int borrowingLimit = 3;

    @ManyToMany(mappedBy = "borrowers")
    @JsonIgnore
    private Set<LoanRecord> records =  new HashSet<>();

    public String getFullName(){
        return firstName +' '+lastName;
    }
}
