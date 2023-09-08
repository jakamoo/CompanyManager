package com.enoca.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "employees")

public class EmployeeEntity extends AbstractEntityWithNameAndId<Long>{
    @Column
    int age;

    @Column
    Long companyId;

    @Builder
    public EmployeeEntity(Long id, String name, int age, Long companyId) {
        super(id, name);
        this.age = age;
        this.companyId = companyId;
    }
    public EmployeeEntity() {
        super();
    }
}