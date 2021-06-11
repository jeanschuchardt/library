package com.jb.library.controller;

import com.jb.library.entity.Page;
import com.jb.library.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/findAll")
    public List<Page> findAll(){
        return pageService.find();
    }
}
