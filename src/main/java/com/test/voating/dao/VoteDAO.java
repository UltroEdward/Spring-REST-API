package com.test.voating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.entity.VoteRoom;

public interface VoteDAO extends JpaRepository<VoteRoom, Integer> {

}
