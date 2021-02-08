package com.jb.library.repository;

import com.jb.library.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("borrowerRepository")
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {

    public Borrower findByFirstNameAndLastName(String firstName, String lastName);

    public Borrower findById(int borrowerId);
}
