package com.jb.library.service;

import com.jb.library.dto.BookDto;
import com.jb.library.dto.PageDto;
import com.jb.library.entity.Book;
import com.jb.library.entity.Page;
import com.jb.library.repository.PageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public List<PageDto> find() {
        List<Page> pages = pageRepository.findAll();
        List<PageDto> pageDtos = new ArrayList<>();
        for (Page p : pages) {

            PageDto page = new ModelMapper().map(p, PageDto.class);

            Book book = p.getBook();
            BookDto bookDto = new ModelMapper().map(book, BookDto.class);

            page.setBook(bookDto);
            pageDtos.add(page);

        }
        return pageDtos;
    }
}
