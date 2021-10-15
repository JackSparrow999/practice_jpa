package com.revise.springboot.services;

import com.revise.springboot.dtos.CreateBookReq;
import com.revise.springboot.dtos.CreateBookRes;
import com.revise.springboot.enums.Genre;
import com.revise.springboot.models.Book;
import com.revise.springboot.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository br;

    public List<CreateBookRes> getAllBooks(){
        return br.findAll().stream().map(b -> new CreateBookRes(b))
                .collect(Collectors.toList());
    }

    public CreateBookRes getBookById(int id){
        return br.findById(id).map(b -> new CreateBookRes(b))
                .stream()
                .findFirst()
                .orElse(null);
    }

    public CreateBookRes createBook(CreateBookReq req){
        return new CreateBookRes(br.save(new Book(req)));
    }

    public List<CreateBookRes> getAllBooksByGenres(Genre g){
        return br.findAll().stream().map(b -> new CreateBookRes(b))
                .collect(Collectors.toList());
    }

}
