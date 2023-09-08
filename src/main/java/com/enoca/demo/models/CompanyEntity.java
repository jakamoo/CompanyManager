package com.enoca.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "companies")
public class CompanyEntity extends AbstractEntityWithNameAndId<Long> {

    @Column
    private String city;

    @OneToMany(targetEntity = EmployeeEntity.class)
    @JoinColumn(name = "companyId")
    private List<EmployeeEntity> employees;


    @Builder
    public CompanyEntity(Long id, String name,String city,List<EmployeeEntity> employees) {

        super(id, name);
        this.city=city;
        this.employees=employees;
    }

    public CompanyEntity() {
        super();
    }
}