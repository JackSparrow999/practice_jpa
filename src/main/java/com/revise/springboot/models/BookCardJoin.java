package com.revise.springboot.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "book_card_join")
public class BookCardJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    Card card;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Book book;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateOfIssuance;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateOfReturn;

}
