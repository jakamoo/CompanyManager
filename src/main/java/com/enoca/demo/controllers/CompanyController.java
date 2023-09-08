package com.enoca.demo.controllers;

import com.enoca.demo.models.dataClasses.CompanyInput;
import com.enoca.demo.models.dataClasses.CompanyObject;
import com.enoca.demo.services.CompanyApiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {


    private final CompanyApiServiceImpl companyApiService;
    @PostMapping
    public ResponseEntity<CompanyObject> createCompany(@RequestBody CompanyInput companyInput) {
        CompanyObject companyObject=companyApiService.createCompany(companyInput);
        return ResponseEntity.ok(companyObject);
    }

    @GetMapping
    public ResponseEntity<List<CompanyObject>> retrieveCompanyList() {
        List<CompanyObject> companyObjectList=companyApiService.retrieveCompanyList();
        return ResponseEntity.ok(companyObjectList);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyObject> retrieveCompany(@PathVariable Long companyId) {
        CompanyObject companyObject=companyApiService.retrieveCompany(companyId);
        return ResponseEntity.ok(companyObject);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyObject> updateCompany(@PathVariable Long companyId, @RequestBody CompanyInput companyInput) {
        CompanyObject updatedCompanyObject=companyApiService.updateCompany(companyId,companyInput);
        return ResponseEntity.ok(updatedCompanyObject);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        companyApiService.deleteCompany(companyId);
        return ResponseEntity.ok().build();
    }
}
