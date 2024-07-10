package com.SpringBoot.QuizApplication.Controller;

import com.SpringBoot.QuizApplication.Quiz;
import com.SpringBoot.QuizApplication.Service.QuestionService;
import com.SpringBoot.QuizApplication.Service.QuizService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("play")
public class QuestionController {
    @Autowired
    QuizService quizService;

    @GetMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam int count, @RequestParam String tittle){
         return quizService.createQuiz(count,tittle);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<Quiz>> getQuiz(@PathVariable int id){
        return  quizService.getQuiz(id);
    }
}
