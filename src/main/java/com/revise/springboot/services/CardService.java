package com.revise.springboot.services;

import com.revise.springboot.models.BookCardJoin;
import com.revise.springboot.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookCardJoin bookCardService;



}
