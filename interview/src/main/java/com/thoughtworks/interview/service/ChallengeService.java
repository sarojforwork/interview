package com.thoughtworks.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.thoughtworks.interview.target.StageFourProcessor;
import com.thoughtworks.interview.target.StageOneProcessor;
import com.thoughtworks.interview.target.StageThreeProcessor;
import com.thoughtworks.interview.target.StageTwoProcessor;

@Service
public class ChallengeService {

	@Autowired
	private ApplicationContext context;

	public void executeStage(Integer stage) throws IllegalArgumentException {
		switch(stage) {
		case 1 :
			context.getBean(StageOneProcessor.class).execute();
			break;
		case 2 :
			context.getBean(StageTwoProcessor.class).execute();
			break;
		case 3 :
			context.getBean(StageThreeProcessor.class).execute();
			break;
		case 4 :
			context.getBean(StageFourProcessor.class).execute();
			break;
		default :
			throw new IllegalArgumentException("Stage Not Defined");
		}
	}


}
