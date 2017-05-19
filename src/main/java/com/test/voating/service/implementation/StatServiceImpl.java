package com.test.voating.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.dao.AnswerDAO;
import com.test.voating.dao.QuestionDAO;
import com.test.voating.dao.VoteDAO;
import com.test.voating.models.Stat;
import com.test.voating.models.StatItem;
import com.test.voating.models.entity.Answer;
import com.test.voating.models.entity.Question;
import com.test.voating.models.entity.VoteRoom;
import com.test.voating.service.StatService;
import com.test.voating.service.VoteRoomService;

@Component
public class StatServiceImpl implements StatService {

	@Autowired
	private QuestionDAO questionDao;
	@Autowired
	private VoteRoomService voteRoomService;
	@Autowired
	private AnswerDAO answerDao;
	@Autowired
	private VoteDAO voteDao;

	@Override
	public Stat getStats(int roomId) {
		Stat stat = new Stat();
		VoteRoom room = voteRoomService.findById(roomId);
		Question quest = questionDao.findOne(room.getIdQuestion());

		stat.setQuestion(quest.getName());
		List<Answer> answers = answerDao.selectByQuestionId(room.getIdQuestion());

		List<StatItem> stats = new ArrayList<>();
		for (Answer ans : answers) {
			StatItem st = new StatItem();
			st.setAnswer(ans.getName());
			st.setCount(voteDao.findByAnswerId(ans.getId()).size());
			stats.add(st);
		}

		stat.setItems(stats);
		return stat;

	}

}
