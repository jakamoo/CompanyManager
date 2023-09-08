package com.enoca.demo.models.dataClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CompanyInput {


    @JsonProperty
    @OneToMany(mappedBy = "company")
    private List<EmployeeObject> employees;

    @JsonProperty
    private String name;
    @JsonProperty
    private String city;

}
