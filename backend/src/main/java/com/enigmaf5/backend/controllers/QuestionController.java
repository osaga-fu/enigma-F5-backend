package com.enigmaf5.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigmaf5.backend.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("http://localhost:5173")
public class QuestionController {
    
    private final QuestionService questionService;

    public QuestionController(@Autowired QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionResponse> getAllQuestions(){
        return questionService.getAllQuestions();
    }
}