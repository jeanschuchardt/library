package com.jb.library.service;

import com.jb.library.entity.Page;
import com.jb.library.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public List<Page> find() {
        pageRepository.findAll();
        return pageRepository.findAll();
    }
}
