package com.jb.library.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.library.entity.Author;
import com.jb.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);

        Book todoSample = Book.builder()
                .title("Test2")
                .number(1001)
                .authorList(authorList)
                .pageCount(1000)
                .build();
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
                        number(1003)
                        .authorList(authorList)
                        .pageCount(9999)
                        .build());

        when(bookService.findAll()).thenReturn(booksList);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/findAll").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andDo(print());

    }
    @Test
    void findBYTitle()  throws Exception{
        List<Book> booksList  =  new ArrayList<Book>();
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("burda").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);
        Book book = Book.builder().
                title("Test4").
                number(5545)
                .authorList(authorList)
                .pageCount(9999)
                .build();

        when(bookService.findByTitle("Test4")).thenReturn(book);


        mockMvc.perform(MockMvcRequestBuilders.get("/books/findByTitle?title=Test4").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.number").value(5545))
                .andExpect(jsonPath("$.title").value("Test4"))
                .andExpect(jsonPath("$.pageCount").value(9999))
                .andDo(print());

    }
    @Test
    void successCreateABook() throws  Exception{
        Author a  =  Author.builder().firstName("jean").lastName("burda").build();
        Author b  =  Author.builder().firstName("emanuel").lastName("oliveira").build();
        List<Author> authorList = new ArrayList<>();
        authorList.add(a);
        authorList.add(b);

        Book sampleBook =  Book.builder().
                title("Test3").
                number(1003)
                .authorList(authorList)
                .pageCount(9999)
                .build();
        when(bookService.save(any(Book.class))).thenReturn(sampleBook);
        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson =  objectMapper.writeValueAsString(sampleBook);

        ResultActions result = mockMvc.perform(post("/books/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson));


        result.andExpect(status().isCreated())
                //.andExpect(jsonPath("$.id").value(null))
                .andExpect(jsonPath("$.number").value(1003))
                .andExpect(jsonPath("$.title").value("Test3"))
                .andExpect(jsonPath("$.pageCount").value(9999))
//                .andExpect(jsonPath("$.authorList").value("null"))
//                .andExpect(jsonPath("$.genersList").value("null"))
                .andDo(print());
        ;



    }
}
