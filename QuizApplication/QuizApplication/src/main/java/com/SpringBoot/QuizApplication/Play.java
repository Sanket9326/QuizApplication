package com.SpringBoot.QuizApplication;
import  com.SpringBoot.QuizApplication.Quiz;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String title;

    @ManyToMany
    private List<Quiz> questions;
}
