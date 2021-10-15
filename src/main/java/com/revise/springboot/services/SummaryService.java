package com.revise.springboot.services;

import com.revise.springboot.dtos.SummaryReq;
import com.revise.springboot.dtos.SummaryRes;
import com.revise.springboot.models.Summary;
import com.revise.springboot.repositories.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryService {

    private SummaryRepository summaryRepository;

    @Autowired
    public void setSummaryRepository(SummaryRepository sr){
        this.summaryRepository = sr;
    }

    public List<SummaryRes> getAllSummaries(){
        return summaryRepository.findAll().stream()
                .map(s -> new SummaryRes(s))
                .collect(Collectors.toList());
    }

    public SummaryRes createSummary(SummaryReq req){
        return new SummaryRes(
                summaryRepository.save(
                        new Summary(req)));
    }

}
