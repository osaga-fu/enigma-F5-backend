package com.enigmaf5.backend;

import com.enigmaf5.backend.controllers.QuestionResponse;
import com.enigmaf5.backend.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @Test
    public void testGetAllQuestions() throws Exception {

        QuestionResponse question1 = new QuestionResponse(1L, "Question1");
        QuestionResponse question2 = new QuestionResponse(2L, "Question2");

        List<QuestionResponse> questions = Arrays.asList(question1, question2);

        when(questionService.getAllQuestions()).thenReturn(questions);

        mockMvc.perform(get("/api/questions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].question").value("Question1"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].question").value("Question2"))
                .andExpect(jsonPath("$[1].id").value(2));

    }

    
}
