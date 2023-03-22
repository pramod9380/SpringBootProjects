package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.beans.Employee;
import com.example.springbootrestapi.beans.Employees;
import com.example.springbootrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // read employee data
    @GetMapping(value = "/employees",produces = "application/json")
    public Employees getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/save/employee")
    public Employee saveEmployeeData(@RequestBody Employee employee){
        int id = employeeService.getAllEmployees().getEmployees().size()+1;
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/update/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id){
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/delete/employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }
}
