package com.test.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.test.exception.StoryNotFoundException;
import com.test.model.Story;
import com.test.service.IDeveloperService;
import com.test.service.IPlanService;
import com.test.service.IStoryService;

@Service
public class PlanService implements IPlanService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);

    @Resource
    private IStoryService repositoryStoryRepository;

    @Resource
    private IDeveloperService repositoryDeveloperService;

	@Override
	public void plan() {
		
		Long developerCount = repositoryDeveloperService.count();
		
		Long score = developerCount * 10;
		
		LOGGER.info("SCORE: "+score);
		
		Sort properties = new Sort(Direction.ASC,"creationDate").and(new Sort(Direction.ASC,"value"));
	    
		Iterable<Story> stories = repositoryStoryRepository.findAll(properties);
		
		Iterator<Story> istory = stories.iterator();
		
		int weekNumber = 1;
		int sumValues = 0;
		
		while (istory.hasNext()){
			Story s = istory.next();
			sumValues += s.getValue();
			if (sumValues>score){
				weekNumber++;
				sumValues=s.getValue();
			}
			s.setWeek(weekNumber);
			try {
				repositoryStoryRepository.update(s);
			} catch (StoryNotFoundException e) {
				LOGGER.error("ERROR: IT HAS NOT BEEN POSSIBLE UPDATE STORY "+s+" EXCEPTION MESSAGE"+e.getMessage());
			}
		}
	}
}