package com.enigmaf5.backend.controllers;

import com.enigmaf5.backend.persistence.Question;

public class QuestionResponse {
    private Long id;
    private String question;

    public QuestionResponse(Long id, String question){
        this.id = id;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public static QuestionResponse from(Question question){
        return new QuestionResponse(question.getId(), question.getQuestion());
    }
}
