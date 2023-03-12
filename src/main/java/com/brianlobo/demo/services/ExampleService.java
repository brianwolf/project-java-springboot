package com.brianlobo.demo.services;

import java.util.List;
import java.util.Optional;

import com.brianlobo.demo.models.Example;

public interface ExampleService {

    /**
     * Get a example object
     * 
     * @return a example object
     */
    Example getExample();

    /**
     * Get a example object by id
     * 
     * @param id
     * @return a example object
     */
    Optional<Example> get(Long id);

    /**
     * Get a list of examples ids
     * 
     * @return list of examples ids
     */
    List<Long> list();

    /**
     * Save a example object
     * 
     * @param example
     * @return id created
     */
    Long save(Example example);

    /**
     * Delete a example object
     * 
     * @param id
     */
    void delete(Long id);
}
