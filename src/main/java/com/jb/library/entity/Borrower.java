package com.jb.library.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class Borrower {
    int id;
    String firstName;
    String lastName;
    int borrowingLimit;


}
