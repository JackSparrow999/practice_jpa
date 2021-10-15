package com.revise.springboot.models;

import com.revise.springboot.dtos.AuthorReq;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    int rating;

    //this is the owning side of relationship
    @OneToMany(mappedBy = "author")
    Set<Book> books;

    public Author(AuthorReq ar){
        this.name = ar.getName();
        this.rating = ar.getRating();
    }

}
