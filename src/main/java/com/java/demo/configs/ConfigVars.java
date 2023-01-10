package com.java.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigVars {

    @Autowired
    private Environment env;

    /**
     * Devuelve un valor de la variables de ambiente o en caso de que sea null la
     * obtiene del properties
     * 
     * @param var
     * @return
     */
    public String get(Enum<?> var) {

        String envValue = System.getenv(var.toString());
        String defaultValue = env.getProperty(var.toString());

        return envValue != null ? envValue : defaultValue;
    }
}
