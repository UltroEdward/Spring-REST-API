package com.test.voating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.voating.models.entity.Vote;

public interface VoteDAO extends JpaRepository<Vote, Integer> {

    @Query("select a from Vote a where a.answerId = :answerId and a.roomId= :roomId")
    List<Vote> findByAnswerIdAndRoom(@Param("answerId") int id, @Param("roomId") int roomId);

}
