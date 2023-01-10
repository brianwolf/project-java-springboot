package com.java.demo.controllers;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.java.demo.configs.ConfigVars;
import com.java.demo.configs.Vars;

@RestController
@RequestMapping("/")
public class Admin {

    private static Logger logger = LoggerFactory.getLogger(Admin.class);

    @Autowired
    private ConfigVars configVars;

    @GetMapping("/")
    public ResponseEntity<Object> getMessages() {

        String version = configVars.get(Vars.VERSION);

        HashMap<String, Object> result = new HashMap<>();
        result.put("version", version);

        logger.info(String.format("version = %s", version));

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/vars")
    public ResponseEntity<Object> getVars() {

        HashMap<String, Object> result = new HashMap<>();

        for (Vars var : Vars.values()) {
            result.put(var.toString(), configVars.get(var));
        }

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/docs")
    public RedirectView docs(RedirectAttributes attributes) {
        return new RedirectView("swagger-ui/index.html");
    }
}
