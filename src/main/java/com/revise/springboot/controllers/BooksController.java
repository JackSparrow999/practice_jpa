package com.revise.springboot.controllers;

import com.revise.springboot.dtos.CreateBookReq;
import com.revise.springboot.dtos.CreateBookRes;
import com.revise.springboot.enums.Genre;
import com.revise.springboot.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    /*
    * Each book has a one-to-one mapping with a summary. Every book has to have a summary
    * This is an example of mandatory one-to-one relationship. If no summary then foreign key
    * column remains empty.
    *
    * Every book can have only one author but one author can write may books.
    * This shows an example of one to many mapping in hibernate.
    * */

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

    public List<CreateBookRes> getBooksByGenres(@RequestParam("genre") String genre){
        return bs.getAllBooksByGenres(Genre.fromName(genre));
    }

    @GetMapping("/summary")
    public boolean mapSummaryToBook(@RequestParam("book_id") Integer bid,
                                    @RequestParam("summary_id") Integer sid){
        return bs.mapSummaryToBook(bid, sid);
    }

    @GetMapping("/count")
    public int countBooks(){
        return bs.numOfBooks();
    }

    @GetMapping("/author")
    public boolean mapSummaryToAuthor(@RequestParam("book_id") Integer bid,
                                    @RequestParam("author_id") Integer aid){
        return bs.mapAuthorToBook(bid, aid);
    }

}
