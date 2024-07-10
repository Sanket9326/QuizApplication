package com.SpringBoot.QuizApplication.Service;
import com.SpringBoot.QuizApplication.DAO.QuizDao;
import com.SpringBoot.QuizApplication.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuizDao quizDao ;

    public ResponseEntity<List<Quiz>> getQuestions() {
        try {
            return new ResponseEntity<>(quizDao.findAll(), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> saveData(Quiz quiz) {
        try {
            quizDao.save(quiz);
            return new ResponseEntity<>("Saved", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("NotSaved", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> deleteQuestion(Quiz quiz) {
        try {
            quizDao.delete(quiz);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not Deleted", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> updateQuestion(Quiz quiz) {
        try {
            quizDao.save(quiz);
            return  new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not Updated", HttpStatus.BAD_REQUEST);
    }
}
