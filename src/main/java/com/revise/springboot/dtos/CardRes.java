package com.revise.springboot.dtos;

import com.revise.springboot.enums.CardType;
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

}
