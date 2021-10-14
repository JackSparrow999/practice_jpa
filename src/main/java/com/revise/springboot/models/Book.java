package com.revise.springboot.models;

import com.revise.springboot.dtos.CreateBookReq;
import com.revise.springboot.enums.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public Book(CreateBookReq req){
        this.name = req.getName();
        this.genre = req.getGenre();
        this.createdOn = Date.from(Instant.now());
    }

}
