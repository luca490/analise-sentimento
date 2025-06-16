package com.example.analise_sentimento.controller;

import com.example.analise_sentimento.model.Comment;
import com.example.analise_sentimento.service.SentimentAnalysisService;
import com.example.analise_sentimento.service.SentimentAnalyzeResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/sentiment")
public class SentimentController {

    private final SentimentAnalysisService service;

    @Autowired
    public SentimentController(SentimentAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public SentimentAnalyzeResult analyze(@RequestBody Comment comment) {
        return service.analyze(comment.getText());
    }
}
