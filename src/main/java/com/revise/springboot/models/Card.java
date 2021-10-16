package com.revise.springboot.models;

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

}
