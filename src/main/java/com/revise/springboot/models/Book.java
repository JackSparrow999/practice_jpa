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
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    //owning side of the relationship
    //this is the join column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "summary_id", referencedColumnName = "id")
    private Summary summary;

    public Book(CreateBookReq req){
        this.name = req.getName();
        this.genre = req.getGenre();
        this.createdOn = Date.from(Instant.now());
    }

}
