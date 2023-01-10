package com.java.demo.configs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Clase para manejo de errores de negocio
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class AppException extends Exception {

    private Enum<?> code;
    private String msg;
    private Exception exception;

    public AppException(Enum<?> code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
