package com.test.voating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.voating.model.VoteRoom;

public interface VoteRoomDAO extends JpaRepository<VoteRoom, Integer> {

	public VoteRoom findById(int id);



	public List<VoteRoom> findAll();
}
