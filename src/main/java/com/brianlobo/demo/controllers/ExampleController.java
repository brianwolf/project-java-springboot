package com.brianlobo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brianlobo.demo.configs.AppException;
import com.brianlobo.demo.errors.ExampleServiceErrors;
import com.brianlobo.demo.models.Example;
import com.brianlobo.demo.services.ExampleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/examples")
@Slf4j
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/example")
    public ResponseEntity<?> getExample() {

        Example example = exampleService.getExample();
        log.info(example.toString());

        return ResponseEntity.status(200).body(example);
    }

    @GetMapping("/error")
    public ResponseEntity<?> error() throws Exception {
        throw new Exception("BOOOOM!!!");
    }

    @GetMapping("/error/business")
    public ResponseEntity<?> errorBusiness() throws AppException {
        throw new AppException(ExampleServiceErrors.BOOOM, "Se rompio todo");
    }

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return ResponseEntity
                .status(200)
                .body(exampleService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {

        var optional = exampleService.get(id);
        if (!optional.isPresent()) {
            return ResponseEntity.status(204).body(null);
        }

        return ResponseEntity.status(200).body(optional.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> save(Example example) {

        return ResponseEntity.status(200).body(exampleService.save(example));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        exampleService.delete(id);
        return ResponseEntity.status(204).body(null);
    }
}
