package com.enoca.demo.models.dataClasses;

import com.enoca.demo.models.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CompanyObject {
    @JsonProperty
    private Long id;

    @JsonProperty
    @OneToMany(mappedBy = "company")
    private List<EmployeeObject> employees;

    @JsonProperty
    private String name;
    @JsonProperty
    private String city;







}
