package com.sonny.sa.repository;

import com.sonny.sa.entites.Client;
import com.sonny.sa.entites.Sentiment;
import com.sonny.sa.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
