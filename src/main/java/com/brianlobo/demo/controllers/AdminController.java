package com.brianlobo.demo.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class AdminController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    public ResponseEntity<Object> getMessages() {

        String version = env.getProperty("project.version");

        HashMap<String, Object> result = new HashMap<>();
        result.put("version", version);

        log.info(String.format("version = %s", version));

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/docs")
    public RedirectView docs(RedirectAttributes attributes) {
        return new RedirectView("swagger-ui/index.html");
    }
}
