package com.test.voating.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.voating.exceptions.VoteItemNotFoundException;
import com.test.voating.models.dto.StatDTO;
import com.test.voating.models.dto.StatItemDTO;
import com.test.voating.models.entity.Answer;
import com.test.voating.models.entity.Question;
import com.test.voating.models.entity.VoteRoom;
import com.test.voating.service.AnswerService;
import com.test.voating.service.QuestionService;
import com.test.voating.service.StatService;
import com.test.voating.service.VoteRoomService;
import com.test.voating.service.VotingService;

@Component
public class StatServiceImpl implements StatService {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private VoteRoomService voteRoomService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private VotingService voteService;

    @Override
    public StatDTO getStats(int roomId) throws VoteItemNotFoundException {
	StatDTO stat = new StatDTO();
	VoteRoom room = voteRoomService.findById(roomId);
	Question quest = questionService.findById(room.getIdQuestion());

	stat.setQuestion(quest.getName());
	List<Answer> answers = answerService.selectedByQuestionId(room.getIdQuestion());

	List<StatItemDTO> stats = new ArrayList<>();
	for (Answer ans : answers) {
	    StatItemDTO st = new StatItemDTO();
	    st.setAnswer(ans.getName());
	    st.setCount(voteService.findByAnswerAndRoomId(ans.getId(), roomId).size());
	    stats.add(st);
	}

	stat.setItems(stats);
	return stat;

    }

}
