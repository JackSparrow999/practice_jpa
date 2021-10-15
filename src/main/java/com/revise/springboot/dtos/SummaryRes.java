package com.revise.springboot.dtos;

import com.revise.springboot.models.Summary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SummaryRes {

    Integer id;

    String summary;

    int words;

    public SummaryRes(Summary s){
        this.id = s.getId();
        this.summary = s.getSummary();
        this.words = s.getWords();
    }

}
