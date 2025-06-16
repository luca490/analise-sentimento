package com.example.analise_sentimento.service;

import com.example.analise_sentimento.model.Sentiment;
import com.example.analise_sentimento.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentAnalysisService {

    private List<String> positiveWords = List.of("feliz", "ótimo", "incrível", "perfeito");
    private List<String> negativeWords = List.of("triste", "péssimo", "horrível", "ruim");

    public SentimentAnalyzeResult analyze(String text) {
        int score = 0;
        for (String word : text.toLowerCase().split("\\s+")) {
            if (positiveWords.contains(word)) score++;
            if (negativeWords.contains(word)) score--;
        }
        Sentiment sentiment = Sentiment.NEUTRAL;
        if (score > 0) sentiment = Sentiment.POSITIVE;
        if (score < 0) sentiment = Sentiment.NEGATIVE;

        return new SentimentAnalyzeResult(text, sentiment);
    }
}
