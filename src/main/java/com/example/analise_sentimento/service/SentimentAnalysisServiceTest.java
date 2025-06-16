package com.example.analise_sentimento.service;

import com.example.analise_sentimento.model.Sentiment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SentimentAnalysisServiceTest {

    private final SentimentAnalysisService service = new SentimentAnalysisService();

    @Test
    void deveRetornarPositivo() {
        var resultado = service.analyze("Hoje está incrível e perfeito!");
        assertEquals(Sentiment.POSITIVE, resultado.sentiment());
    }

    @Test
    void deveRetornarNegativo() {
        var resultado = service.analyze("Dia horrível e péssimo");
        assertEquals(Sentiment.NEGATIVE, resultado.sentiment());
    }

    @Test
    void deveRetornarNeutro() {
        var resultado = service.analyze("Apenas um texto qualquer");
        assertEquals(Sentiment.NEUTRAL, resultado.sentiment());
    }
}
