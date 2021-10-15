package com.revise.springboot.controllers;

import com.revise.springboot.dtos.SummaryReq;
import com.revise.springboot.dtos.SummaryRes;
import com.revise.springboot.models.Summary;
import com.revise.springboot.services.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summaries")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping
    public List<SummaryRes> getAllSummaries(){
        return summaryService.getAllSummaries();
    }

    @PostMapping("/create")
    public SummaryRes createSummary(@RequestBody SummaryReq req){
        return summaryService.createSummary(req);
    }

}
