package com.brianlobo.demo.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianlobo.demo.models.Example;
import com.brianlobo.demo.repositories.ExampleRepository;
import com.brianlobo.demo.repositories.entities.ExampleEntity;
import com.brianlobo.demo.services.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository repository;

    @Override
    public Example getExample() {
        return Example.builder()
                .date(LocalDate.now())
                .doubleVar(1.4)
                .str("Hola")
                .integer(10)
                .build();
    }

    @Override
    public Optional<Example> get(Long id) {
        return repository.findById(id)
                .map(e -> e.toModel());
    }

    @Override
    public List<Long> list() {

        List<Long> listIds = new ArrayList<>();

        for (var e : repository.findAll()) {
            listIds.add(e.getId());
        }

        return listIds;
    }

    @Override
    public Long save(Example example) {
        return repository.save(new ExampleEntity(example))
                .getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
