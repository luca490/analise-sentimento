package com.example.analise_sentimento.service;

import com.example.analise_sentimento.model.Sentiment;

public record SentimentAnalyzeResult (String text, Sentiment sentiment) { }
