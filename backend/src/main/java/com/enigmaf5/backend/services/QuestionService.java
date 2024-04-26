package com.enigmaf5.backend.services;

import com.enigmaf5.backend.controllers.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmaf5.backend.persistence.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(@Autowired QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<QuestionResponse> getAllQuestions() {

        return questionRepository.findAll().stream()
                .map(QuestionResponse::from)
                .collect(Collectors.toList());
    }
}
