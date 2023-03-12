package com.brianlobo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brianlobo.demo.repositories.entities.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
}
