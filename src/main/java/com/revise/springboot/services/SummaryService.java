package com.revise.springboot.services;

import com.revise.springboot.models.Summary;
import com.revise.springboot.repositories.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    private SummaryRepository summaryRepository;

    @Autowired
    public void setSummaryRepository(SummaryRepository sr){
        this.summaryRepository = sr;
    }

    public List<Summary> getAllSummaries(){
        return summaryRepository.findAll();
    }

}
