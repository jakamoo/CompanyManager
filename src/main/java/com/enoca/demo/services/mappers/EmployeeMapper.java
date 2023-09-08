package com.enoca.demo.services.mappers;

import com.enoca.demo.models.EmployeeEntity;
import com.enoca.demo.models.dataClasses.EmployeeInput;
import com.enoca.demo.models.dataClasses.EmployeeObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EmployeeMapper {



    public EmployeeEntity toEmployeeEntity(EmployeeInput employeeInput) {
        if (employeeInput == null) {
            return null;
        }

        return EmployeeEntity.builder()
                .age(Optional.of(employeeInput.getAge()).orElse(0))
                .companyId(employeeInput.getCompanyId())
                .name(Optional.ofNullable(employeeInput.getName()).orElse(""))
                .build();
    }

    public EmployeeEntity toEmployeeEntity(EmployeeObject employeeObject) {
        if (employeeObject == null) {
            return null;
        }

        return EmployeeEntity.builder()
                .age(Optional.of(employeeObject.getAge()).orElse(0))
                .companyId(employeeObject.getCompanyId())
                .name(Optional.ofNullable(employeeObject.getName()).orElse(""))
                .id(employeeObject.getId())
                .build();
    }

    public EmployeeObject toEmployeeObject(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        }

        return EmployeeObject.builder()
                .age(Optional.of(employeeEntity.getAge()).orElse(0))
                .name(Optional.ofNullable(employeeEntity.getName()).orElse(""))
                .companyId(employeeEntity.getCompanyId())
                .id(employeeEntity.getId())
                .build();
    }
}
