package com.sonny.sa.service;


import com.sonny.sa.entites.Client;
import com.sonny.sa.entites.Sentiment;
import com.sonny.sa.enums.TypeSentiment;
import com.sonny.sa.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        // Analyse du sentiment
        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else sentiment.setType(TypeSentiment.POSITIF);

        this.sentimentRepository.save(sentiment);
    }


    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null){
            return this.sentimentRepository.findAll();
        }else return this.sentimentRepository.findByType(type);

    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
