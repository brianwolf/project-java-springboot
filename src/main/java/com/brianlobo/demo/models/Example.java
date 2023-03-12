package com.brianlobo.demo.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Example {

    private Long id;
    private String str;
    private LocalDate date;
    private Double doubleVar;
    private Integer integer;
}
