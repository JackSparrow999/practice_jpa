package com.revise.springboot.dtos;

import com.revise.springboot.enums.CardType;
import com.revise.springboot.models.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CardRes {

    Integer id;

    CardType cardType;

    Integer borrowLimit;

    Integer cost;

    Boolean owned;

    public CardRes(Card card){
        this.id = card.getId();
        this.cardType = card.getType();
        this.borrowLimit = card.getBorrowLimit();
        this.cost = card.getCost();
        this.owned = card.isOwned();
    }

}
