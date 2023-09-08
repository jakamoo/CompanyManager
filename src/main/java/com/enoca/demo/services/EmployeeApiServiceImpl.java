package com.enoca.demo.services;


import com.enoca.demo.exceptions.CompanyServiceNotFoundRestException;
import com.enoca.demo.models.CompanyEntity;
import com.enoca.demo.models.EmployeeEntity;
import com.enoca.demo.models.dataClasses.EmployeeInput;
import com.enoca.demo.models.dataClasses.EmployeeObject;
import com.enoca.demo.repositories.CompanyRepository;
import com.enoca.demo.repositories.EmployeeRepository;
import com.enoca.demo.services.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@ControllerAdvice
@AllArgsConstructor
public class EmployeeApiServiceImpl  {


    private final EmployeeMapper employeeMapper;

    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;


    @NotNull
    public EmployeeObject createEmployee(@NotNull EmployeeInput employeeInput) {

        Optional<CompanyEntity> company = companyRepository.findById(employeeInput.getCompanyId());
        if (company.isEmpty()) {
            throw new CompanyServiceNotFoundRestException(employeeInput.getCompanyId());
        }

        EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employeeInput);
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeMapper.toEmployeeObject(employeeEntity);


    }

    public void deleteEmployee(long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee With Id " + employeeId + " is not Present!"));
        employeeRepository.deleteById(employeeId);
    }

    @NotNull
    public EmployeeObject updateEmployee(long employeeId, @NotNull EmployeeInput employeeInput) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee With Id " + employeeId + " is not Present!"));


        employeeEntity.setName(employeeInput.getName());
        employeeEntity.setAge(employeeInput.getAge());
        employeeEntity.setCompanyId(employeeEntity.getCompanyId());
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

        return employeeMapper.toEmployeeObject(savedEmployee);
    }


    @NotNull
    public EmployeeObject retrieveEmployee(long employeeId) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee With Id " + employeeId + " is not Present!");
        }

        EmployeeEntity employee = employeeOptional.get();


        return employeeMapper.toEmployeeObject(employee);

    }

    @NotNull
    public List<EmployeeObject> retrieveEmployeeList() {

        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeObject)
                .collect(Collectors.toList());
    }
}




