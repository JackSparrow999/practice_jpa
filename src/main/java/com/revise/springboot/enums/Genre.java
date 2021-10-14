package com.revise.springboot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
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
}
