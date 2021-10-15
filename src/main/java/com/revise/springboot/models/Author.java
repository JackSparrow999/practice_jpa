package com.revise.springboot.models;

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

    //this is the owning side of relationship
    @OneToMany(mappedBy = "author")
    Set<Book> books;

}
