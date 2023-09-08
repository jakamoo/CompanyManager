package com.enoca.demo.controllers;

import com.enoca.demo.models.dataClasses.EmployeeInput;
import com.enoca.demo.models.dataClasses.EmployeeObject;
import com.enoca.demo.services.EmployeeApiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {


   private final EmployeeApiServiceImpl employeeApiService;
    @PostMapping
    public ResponseEntity<EmployeeObject> createEmployee(@RequestBody EmployeeInput employeeInput) {
        EmployeeObject employeeObject=employeeApiService.createEmployee(employeeInput);
        return ResponseEntity.ok(employeeObject);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeObject>> retrieveEmployeeList() {
        List<EmployeeObject> employeeObjectList=employeeApiService.retrieveEmployeeList();
        return ResponseEntity.ok(employeeObjectList); // Return the list of employees
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeObject> retrieveEmployee(@PathVariable Long employeeId) {
        EmployeeObject employeeObject=employeeApiService.retrieveEmployee(employeeId);
        return ResponseEntity.ok(employeeObject);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeObject> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeInput employeeInput) {
        EmployeeObject updatedEmployeeObject=employeeApiService.updateEmployee(employeeId,employeeInput);
        return ResponseEntity.ok(updatedEmployeeObject);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeApiService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
