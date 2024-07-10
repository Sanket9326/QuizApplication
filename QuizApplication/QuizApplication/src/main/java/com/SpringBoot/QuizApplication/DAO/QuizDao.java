package com.SpringBoot.QuizApplication.DAO;

import com.SpringBoot.QuizApplication.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query(value = "SELECT * FROM Quiz q ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Quiz> findTotalNumberOfQuestionAsCount(@Param("count") int count);
}
