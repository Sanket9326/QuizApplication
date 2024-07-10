package com.SpringBoot.QuizApplication.Controller;

import com.SpringBoot.QuizApplication.Quiz;
import com.SpringBoot.QuizApplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

      @Autowired
      QuestionService questionService;

      @GetMapping("allQuestions")
      public ResponseEntity<List<Quiz>> allQuestions(){
         return questionService.getQuestions();
      }
      @PutMapping("add")
      public ResponseEntity<String> addQuestion(@RequestBody Quiz quiz){
        return questionService.saveData(quiz);
      }
      @DeleteMapping("delete")
      public ResponseEntity<String> deleteQuestion(@RequestBody Quiz quiz){
          return questionService.deleteQuestion(quiz);
      }
      @PutMapping("update")
      public ResponseEntity<String> updateQuestion(@RequestBody Quiz quiz){
          return questionService.updateQuestion(quiz);
      }
}
