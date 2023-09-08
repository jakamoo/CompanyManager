package com.enoca.demo.services.mappers;

import com.enoca.demo.models.CompanyEntity;
import com.enoca.demo.models.EmployeeEntity;
import com.enoca.demo.models.dataClasses.CompanyInput;
import com.enoca.demo.models.dataClasses.CompanyObject;
import com.enoca.demo.models.dataClasses.EmployeeObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CompanyMapper {

    private final EmployeeMapper employeeMapper;

    public CompanyEntity toCompanyEntity(CompanyInput companyInput) {
        if (companyInput == null) {
            return null;
        }

        List<EmployeeEntity> employeeEntities = Optional.ofNullable(companyInput.getEmployees())
                .orElse(Collections.emptyList())
                .stream()
                .map(employeeMapper::toEmployeeEntity)
                .collect(Collectors.toList());

        return CompanyEntity.builder()
                .city(Optional.ofNullable(companyInput.getCity()).orElse(""))
                .name(Optional.ofNullable(companyInput.getName()).orElse(""))
                .employees(employeeEntities)
                .build();
    }

    public CompanyEntity toCompanyEntity(CompanyObject companyObject) {
        if (companyObject == null) {
            return null;
        }

        List<EmployeeEntity> employeeEntities = Optional.ofNullable(companyObject.getEmployees())
                .orElse(Collections.emptyList())
                .stream()
                .map(employeeMapper::toEmployeeEntity)
                .collect(Collectors.toList());

        return CompanyEntity.builder()
                .city(Optional.ofNullable(companyObject.getCity()).orElse(""))
                .name(Optional.ofNullable(companyObject.getName()).orElse(""))
                .employees(employeeEntities)
                .id(companyObject.getId())
                .build();
    }

    public CompanyObject toCompanyObject(CompanyEntity companyEntity) {
        if (companyEntity == null) {
            return null;
        }

        List<EmployeeObject> employeeObjects = Optional.ofNullable(companyEntity.getEmployees())
                .orElse(Collections.emptyList())
                .stream()
                .map(employeeMapper::toEmployeeObject)
                .collect(Collectors.toList());

        return CompanyObject.builder()
                .city(Optional.ofNullable(companyEntity.getCity()).orElse(""))
                .name(Optional.ofNullable(companyEntity.getName()).orElse(""))
                .employees(employeeObjects)
                .id(companyEntity.getId())
                .build();
    }
}
