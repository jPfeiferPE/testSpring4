package com.test.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.exception.BugNotFoundException;
import com.test.model.Bug;
import com.test.repos.BugRepository;
import com.test.service.IBugService;

/**
 * This implementation of the DeveloperService interface communicates with
 * the database by using a Spring Data JPA repository.
 * 
 */
@Service
public class RepositoryBugService implements IBugService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryBugService.class);

    @Resource
    private BugRepository bugRepository;

    @Transactional
    public long count() {
        return bugRepository.count();
    }
    
    @Override
    @Transactional
	public Bug create(Bug created) {
		LOGGER.debug("Creating a new bug with information: " + created);
		return bugRepository.save(created);
	}
	
	@Override
	@Transactional
	public Bug update(Bug updated) {
		 LOGGER.debug("Updating story with information: " + updated);
		 return bugRepository.save(updated);
	}

	@Override
	@Transactional(readOnly = true)
	public Bug findById(Long id) throws BugNotFoundException{
		LOGGER.debug("Finding story by id: " + id);
		Bug story = bugRepository.findOne(id);
		if (story == null)
			throw new BugNotFoundException();
		return story;
	}

}
