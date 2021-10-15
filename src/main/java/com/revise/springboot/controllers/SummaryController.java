package com.revise.springboot.controllers;

import com.revise.springboot.models.Summary;
import com.revise.springboot.services.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping
    public List<Summary> getAllSummaries(){
        return summaryService.getAllSummaries();
    }

}
