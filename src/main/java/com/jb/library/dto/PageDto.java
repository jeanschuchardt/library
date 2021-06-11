package com.jb.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    private int id;

    private int number;

    private String content;

    private String chapter;

    private BookDto book;
}
