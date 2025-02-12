package com.spring.bikram.boot.tutorial.service;

import ai.djl.Device;
import ai.djl.inference.Predictor;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class AILocationSimilarityService {
    private ZooModel<String, float[]> model;
    
    @PostConstruct
    public void init() throws Exception {
        // Load the pre-trained model (using MiniLM as an example)
        Criteria<String, float[]> criteria = Criteria.builder()
                .setTypes(String.class, float[].class)
                .optEngine("PyTorch")
                .optModelUrls("djl://ai.djl.huggingface.pytorch/sentence-transformers/all-MiniLM-L6-v2")
                .optProgress(new ProgressBar())
                .build();

        model = criteria.loadModel();
    }

    public double calculateSimilarity(String location1, String location2) throws Exception {
        try (Predictor<String, float[]> predictor = model.newPredictor()) {
            // Get embeddings for both locations
            float[] embedding1 = predictor.predict(location1);
            float[] embedding2 = predictor.predict(location2);

            // Calculate cosine similarity
            return cosineSimilarity(embedding1, embedding2);
        }
    }

    private double cosineSimilarity(float[] vec1, float[] vec2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (int i = 0; i < vec1.length; i++) {
            dotProduct += vec1[i] * vec2[i];
            norm1 += vec1[i] * vec1[i];
            norm2 += vec2[i] * vec2[i];
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
} 