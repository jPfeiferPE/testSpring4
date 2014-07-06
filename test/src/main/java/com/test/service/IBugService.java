package com.test.service;

import com.test.exception.BugNotFoundException;
import com.test.model.Bug;

/**
 * Declares methods used to obtain and modify developer information.
 * 
 */
public interface IBugService {

    public Bug create(Bug created);


    /**
     * Gets the count of stories
     * @return
     */
    public long count();

    /**
     * Updates the information of a developer.
     * @param updated   The information of the updated story.
     * @return  The updated story.
     * @throws BugNotFoundException  if no story is found with given id.
     */
    public Bug update(Bug updated) throws BugNotFoundException;

    public Bug findById(Long id) throws BugNotFoundException;
    
}
