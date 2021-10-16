package com.revise.springboot.services;

import com.revise.springboot.dtos.CardRes;
import com.revise.springboot.dtos.GenerateCardReq;
import com.revise.springboot.models.BookCardJoin;
import com.revise.springboot.models.Card;
import com.revise.springboot.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookCardJoin bookCardService;

    public CardRes createCard(GenerateCardReq cardReq){
        return new CardRes(cardRepository.save(new Card(cardReq)));
    }

    public List<CardRes> getAllCards(){
        return cardRepository.findAll()
                .stream()
                .map(c -> new CardRes(c))
                .collect(Collectors.toList());
    }

}
