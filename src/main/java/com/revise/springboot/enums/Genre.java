package com.revise.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum Genre {

    HORROR("Horror"),
    FICTION("Fiction"),
    ADVENTURE("Adventure"),
    DRAMA("Drama");

    String value;

    static Map<String, Genre> mp = new HashMap<>();

    static{
        for(Genre g: Genre.values())
            mp.put(g.toString(), g);
    }

    public static Genre fromName(String s){
        return mp.get(s);
    }
}
