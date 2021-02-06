package com.jb.library.controler;

import com.jb.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import com.jb.library.entity.Book;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class bookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getAllBooks()  throws Exception{
        List<Book> booksList  =  new ArrayList<Book>();
        booksList.add(
                Book.builder().
                        title("Test2").
                        number(1001).build());
        booksList.add(
                Book.builder().
                        title("Test2").
                        number(1002).build());
        booksList.add(
                Book.builder().
                        title("Test3").
                        number(1003).build());

        when(bookService.findAll()).thenReturn(booksList);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/findAll").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andDo(print());

    }

}
