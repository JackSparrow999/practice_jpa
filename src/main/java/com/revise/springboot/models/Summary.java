package com.revise.springboot.models;

import com.revise.springboot.dtos.SummaryReq;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    String summary;

    int words;

    //summary is the referenced table
    //this is not the owner of the relationship
    @OneToOne(mappedBy = "summary")
    Book book;

    public Summary(SummaryReq summaryReq){
        this.summary = summaryReq.getSummary();
        this.words = summaryReq.getSummary().split("").length;
    }

}
