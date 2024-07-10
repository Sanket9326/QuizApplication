package com.SpringBoot.QuizApplication.DAO;

import com.SpringBoot.QuizApplication.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayDao extends JpaRepository<Play, Integer> {
}
