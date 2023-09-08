package com.enoca.demo.models.dataClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// EmployeeObject
@Builder
@Getter
@Setter
public class EmployeeObject {
    @JsonProperty
    private Long id;

    @JsonProperty
    private int age;

    @JsonProperty
    private String name;

    @JsonProperty
    private Long companyId;

}