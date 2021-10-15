package com.revise.springboot.controllers;

import com.revise.springboot.dtos.AuthorReq;
import com.revise.springboot.dtos.AuthorRes;
import com.revise.springboot.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    AuthorService as;

    @PostMapping("/create")
    public AuthorRes createAuthor(@RequestBody AuthorReq req){
        return as.createAuthor(req);
    }

    @GetMapping
    public List<AuthorRes> getAllAuthors(){
        return as.getAllAuthors();
    }

}
