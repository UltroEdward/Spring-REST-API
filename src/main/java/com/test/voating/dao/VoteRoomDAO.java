package com.test.voating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.models.entity.VoteRoom;

public interface VoteRoomDAO extends JpaRepository<VoteRoom, Integer> {

}
