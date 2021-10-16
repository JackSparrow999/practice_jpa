package com.revise.springboot.controllers;

import com.revise.springboot.dtos.BorrowReq;
import com.revise.springboot.dtos.CardRes;
import com.revise.springboot.dtos.GenerateCardReq;
import com.revise.springboot.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardService cardService;

    @PostMapping
    public CardRes createCard(@RequestBody GenerateCardReq req){
        return cardService.createCard(req);
    }

    @GetMapping
    public List<CardRes> getAllCards(){
        return cardService.getAllCards();
    }

    @PostMapping("/borrow")
    public Boolean borrowBook(@RequestBody BorrowReq req){
        return cardService.borrowBook(req.getBookId(), req.getCardId());
    }

}