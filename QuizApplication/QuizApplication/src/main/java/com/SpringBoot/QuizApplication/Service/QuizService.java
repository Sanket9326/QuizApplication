package com.SpringBoot.QuizApplication.Service;

import com.SpringBoot.QuizApplication.DAO.PlayDao;
import com.SpringBoot.QuizApplication.DAO.QuizDao;
import com.SpringBoot.QuizApplication.Play;
import com.SpringBoot.QuizApplication.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    PlayDao playDaoDao;

    @Autowired
    QuizDao quizDaoDao;


    public ResponseEntity<String> createQuiz(int count,String tittle) {
        try {
            List<Quiz> quizList = quizDaoDao.findTotalNumberOfQuestionAsCount(count);
            Play play = new Play();
            play.setTitle(tittle);
            play.setQuestions(quizList);
            playDaoDao.save(play);
            return new ResponseEntity<>("Sucess", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Quiz>> getQuiz(int id) {
       try{
           Optional<Play> quiz = playDaoDao.findById(id);
           List<Quiz> quizList = quiz.get().getQuestions();
           return new ResponseEntity<>(quizList, HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
