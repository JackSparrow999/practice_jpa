package com.revise.springboot.services;

import com.revise.springboot.dtos.CardRes;
import com.revise.springboot.dtos.GenerateCardReq;
import com.revise.springboot.models.Book;
import com.revise.springboot.models.BookCardJoin;
import com.revise.springboot.models.Card;
import com.revise.springboot.repositories.BookCardJoinRepository;
import com.revise.springboot.repositories.BookRepository;
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
    BookCardJoinRepository bcRepository;

    @Autowired
    BookRepository bookRepository;

    public CardRes createCard(GenerateCardReq cardReq){
        return new CardRes(cardRepository.save(new Card(cardReq)));
    }

    public List<CardRes> getAllCards(){
        return cardRepository.findAll()
                .stream()
                .map(c -> new CardRes(c))
                .collect(Collectors.toList());
    }

    public boolean borrowBook(int bid, int cid){
        Book b = bookRepository.findById(bid).orElse(null);
        Card c = cardRepository.findById(cid).orElse(null);

        if(b == null || c == null)
            return false;

        if(!checkIfBorrowAllowed(b, c))
            return false;

        bcRepository.save(new BookCardJoin(b, c));
        cardRepository.updateCost(cid, c.getCost()+5);

        return true;
    }

    public boolean checkIfBorrowAllowed(Book b, Card c){
        //can't borrow against card that is not owned
        if(!c.isOwned())
            return false;

        //can't cross borrow limit on card
        if(cardRepository.numberOfBooksIssuedByCard(c.getId()) >= c.getBorrowLimit())
            return false;

        //can't borrow another book of same type if already borrowed once and borrow is active
        if(bcRepository.numOfBookInstanceAlreadyBorrowedWithCard(b.getId(), c.getId()) >= 1)
            return false;

        return true;
    }

    public boolean returnBook(int bid, int cid){
        Book b = bookRepository.findById(bid).orElse(null);
        Card c = cardRepository.findById(cid).orElse(null);

        if(b == null || c == null)
            return false;

        bcRepository.returnBook(bid, cid);

        return true;
    }

}
