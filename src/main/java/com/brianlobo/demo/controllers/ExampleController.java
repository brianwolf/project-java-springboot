package com.brianlobo.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brianlobo.demo.configs.AppException;
import com.brianlobo.demo.errors.ExampleServiceErrors;
import com.brianlobo.demo.models.Example;
import com.brianlobo.demo.services.ExampleService;

@RestController
@RequestMapping("/examples")
public class ExampleController {

    private static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/")
    public ResponseEntity<?> getExample() {

        Example example = exampleService.getExample();
        logger.info(example.toString());

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
}
