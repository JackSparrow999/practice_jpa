package com.revise.springboot.dtos;

import com.revise.springboot.models.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthorRes {

    Integer id;

    String name;

    Integer rating;

    public AuthorRes(Author a){
        BeanUtils.copyProperties(a, this);
    }

}
