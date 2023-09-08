package com.enoca.demo.models.dataClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmployeeInput {

    @JsonProperty
    private int age;

    @JsonProperty
    private String name;

    @JsonProperty
    private Long  companyId;
}
