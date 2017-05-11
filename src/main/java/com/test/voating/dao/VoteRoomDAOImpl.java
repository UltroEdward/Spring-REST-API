package com.test.voating.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.model.VoteRoom;

@Component("voteRomDAO")
public class VoteRoomDAOImpl implements VoteRoomDAO {

	@Autowired
	private EntityManager entityManager;

	public VoteRoom findRoomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveVoteRoom(VoteRoom room) {

	}

	public void updateVoteRoom(VoteRoom room) {

	}

	@SuppressWarnings("unchecked")
	public List<VoteRoom> getVoteRooms() {
		String hql = "FROM VoteRoom as room ORDER BY room.id";
		return (List<VoteRoom>) entityManager.createQuery(hql).getResultList();

	}

}
