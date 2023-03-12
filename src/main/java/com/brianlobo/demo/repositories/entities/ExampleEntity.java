package com.brianlobo.demo.repositories.entities;

import java.time.LocalDate;

import com.brianlobo.demo.models.Example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "EXAMPLES")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STR")
    private String str;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DOUBLE_VAR")
    private Double doubleVar;

    @Column(name = "INTEGER")
    private Integer integer;

    public Example toModel() {
        return Example.builder()
                .id(this.id)
                .date(this.date)
                .doubleVar(this.doubleVar)
                .str(this.str)
                .integer(this.integer)
                .build();
    }

    public ExampleEntity(Example example) {
        this.id = example.getId();
        this.str = example.getStr();
        this.date = example.getDate();
        this.doubleVar = example.getDoubleVar();
        this.integer = example.getInteger();
    }
}
