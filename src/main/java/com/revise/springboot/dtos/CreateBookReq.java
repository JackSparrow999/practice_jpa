package com.revise.springboot.dtos;

import com.revise.springboot.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CreateBookReq {

    String name;

    Genre genre;

}
