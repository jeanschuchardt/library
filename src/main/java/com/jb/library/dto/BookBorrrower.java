package com.jb.library.dto;

import com.jb.library.entity.Borrower;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookBorrrower {
    String title;
    List<Borrower> borrowerList;

}
