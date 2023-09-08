package com.enoca.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@MappedSuperclass
@Data
@AllArgsConstructor
abstract public class AbstractEntityWithNameAndId<T> {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
    @Column
    private String name;

    AbstractEntityWithNameAndId(){}


}
