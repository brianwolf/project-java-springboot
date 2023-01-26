package com.demo.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.demo.models.Example;
import com.demo.services.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public Example getExample() {
        return Example.builder()
                .date(new Date())
                .doubleVar(1.4)
                .str("Hola")
                .integer(10)
                .build();
    }

}
