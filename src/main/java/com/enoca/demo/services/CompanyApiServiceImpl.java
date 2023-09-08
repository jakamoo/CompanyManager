package com.enoca.demo.services;

import com.enoca.demo.models.CompanyEntity;
import com.enoca.demo.models.EmployeeEntity;
import com.enoca.demo.models.dataClasses.CompanyInput;
import com.enoca.demo.models.dataClasses.CompanyObject;
import com.enoca.demo.repositories.CompanyRepository;
import com.enoca.demo.services.mappers.CompanyMapper;
import com.enoca.demo.services.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@ControllerAdvice
@AllArgsConstructor
public class CompanyApiServiceImpl {


    private final CompanyMapper companyMapper;


    private final CompanyRepository companyRepository;

    private final EmployeeMapper employeeMapper;

    @NotNull
    public CompanyObject createCompany(@NotNull CompanyInput companyInput) {


        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyInput);
        companyEntity = companyRepository.save(companyEntity);
        return companyMapper.toCompanyObject(companyEntity);


    }

    public void deleteCompany(long companyId) {
        companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company With Id " + companyId + " is not Present!"));
        companyRepository.deleteById(companyId);
    }

    @NotNull
    public CompanyObject updateCompany(long companyId, @NotNull CompanyInput companyInput) {

        CompanyEntity companyEntity = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company With Id " + companyId + " is not Present!"));


        companyEntity.setName(companyInput.getName());
        companyEntity.setCity(companyInput.getCity());
        List<EmployeeEntity> employeeEntities = Objects.requireNonNull(companyInput.getEmployees())
                .stream()
                .map(employeeMapper::toEmployeeEntity)
                .collect(Collectors.toList());

        companyEntity.setEmployees(employeeEntities);

        CompanyEntity savedCompany = companyRepository.save(companyEntity);

        return companyMapper.toCompanyObject(savedCompany);
    }


    @NotNull
    public CompanyObject retrieveCompany(long companyId) {
        Optional<CompanyEntity> companyOptional = companyRepository.findById(companyId);

        if (companyOptional.isEmpty()) {
            throw new RuntimeException("Company With Id " + companyId + " is not Present!");
        }

        CompanyEntity company = companyOptional.get();


        return companyMapper.toCompanyObject(company);

    }

    @NotNull
    public List<CompanyObject> retrieveCompanyList() {

        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyObject)
                .collect(Collectors.toList());
    }
}




