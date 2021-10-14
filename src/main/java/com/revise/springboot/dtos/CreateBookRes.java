package com.revise.springboot.dtos;

import com.revise.springboot.enums.Genre;
import com.revise.springboot.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CreateBookRes {

    Integer id;

    String name;

    Genre genre;

    Date createdOn;

    public CreateBookRes(Book b){
        this.id = b.getId();
        this.name = b.getName();
        this.genre = b.getGenre();
        this.createdOn = b.getCreatedOn();
    }
}
