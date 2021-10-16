package com.revise.springboot.models;

import com.revise.springboot.dtos.GenerateCardReq;
import com.revise.springboot.enums.CardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    //mappedBy stores the referenced/parent table name
    @OneToMany(mappedBy = "card")
    Set<BookCardJoin> bookCardJoin;

    @Enumerated(EnumType.STRING)
    CardType type;

    //max number of active books that can be borrowed at any given time
    @Column(name = "borrow_limit")
    int borrowLimit;

    //total cost on card
    int cost;

    //says if this is an active card or deactivated
    boolean owned;

    public Card(GenerateCardReq cardReq){
        this.type = cardReq.getCardType();
        this.borrowLimit = cardReq.getBorrowLimit();
        this.cost = getCost();
        this.owned = true;
    }

}
