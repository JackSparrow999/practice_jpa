package com.revise.springboot.controllers;

import com.revise.springboot.dtos.CreateBookReq;
import com.revise.springboot.dtos.CreateBookRes;
import com.revise.springboot.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BookService bs;

    @Autowired
    public BooksController(BookService bs){
        this.bs = bs;
    }

    @PostMapping("/create")
    public CreateBookRes createBook(@RequestBody CreateBookReq req){
        return bs.createBook(req);
    }

    @GetMapping
    public List<CreateBookRes> getAllBooks(){
        return bs.getAllBooks();
    }

    @GetMapping("/{id}")
    public CreateBookRes getBookById(@PathVariable("id") Integer id){
        return bs.getBookById(id);
    }

}
