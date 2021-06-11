package com.jb.library.dto;

import com.jb.library.entity.Book;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;


@Getter
@Setter
public class BookDto {
    private int id;
    private int number;
    private String title;
    private int pageCount;


}
