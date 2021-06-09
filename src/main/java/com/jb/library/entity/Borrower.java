package com.jb.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
//@Table(name = "borrower", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstName", "lastName"})})
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int borrowingLimit = 3;

    @ManyToMany(mappedBy = "borrowers")
    @JsonIgnore
    private Set<LoanRecord> records = new HashSet<>();

    public String getFullName() {
        return firstName + ' ' + lastName;
    }
}
