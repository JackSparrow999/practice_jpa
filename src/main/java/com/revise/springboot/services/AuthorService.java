package com.revise.springboot.services;

import com.revise.springboot.dtos.AuthorReq;
import com.revise.springboot.dtos.AuthorRes;
import com.revise.springboot.models.Author;
import com.revise.springboot.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository ar;

    public AuthorRes createAuthor(AuthorReq req){
        return new AuthorRes(ar.save(new Author(req)));
    }

    public List<AuthorRes> getAllAuthors(){
        return ar.findAll().stream()
                .map(a -> new AuthorRes(a))
                .collect(Collectors.toList());
    }

}
