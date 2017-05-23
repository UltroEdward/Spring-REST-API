package com.test.voating.service;

import com.test.voating.exceptions.VoteBasicException;
import com.test.voating.models.dto.StatDTO;

public interface StatService {

    public StatDTO getStats(int roomId) throws VoteBasicException;

}
