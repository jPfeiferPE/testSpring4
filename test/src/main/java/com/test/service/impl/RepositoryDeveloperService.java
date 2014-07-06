package com.test.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Developer;
import com.test.repos.DeveloperRepository;
import com.test.service.IDeveloperService;

/**
 * This implementation of the DeveloperService interface communicates with
 * the database by using a Spring Data JPA repository.
 * 
 */
@Service
public class RepositoryDeveloperService implements IDeveloperService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryDeveloperService.class);

    @Resource
    private DeveloperRepository developerRepository;


    @Transactional
    public long count() {
        return developerRepository.count();
    }
    
	@Transactional
	@Override
	public Developer create(Developer created) {
		LOGGER.debug("Creating a new developer with information: " + created);
		return developerRepository.save(created);
	}
	
}