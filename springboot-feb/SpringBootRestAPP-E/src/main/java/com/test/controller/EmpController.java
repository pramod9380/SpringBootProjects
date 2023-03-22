package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmpService;

@RestController
public class EmpController {
		
	@Autowired
	EmpService empService;
	
	@GetMapping(path = "/", produces = "application/json")
	public Employees getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	
	@PostMapping(path = "/", consumes = "application/json")
	@ResponseBody
	public Employees createEmployee(@RequestBody Employee emp)
	{
		Integer id = empService.getAllEmployees().getEmpList().size() + 1;
		
		emp.setId(id);
		
		empService.addEmployee(emp);
		
		return empService.getAllEmployees();
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseBody
	public Employees updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp)
	{
		emp.setId(id);
		
		empService.updateEmployee(emp);
		
		return empService.getAllEmployees();
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public Employees deleteEmployees(@PathVariable("id") Integer id)
	{
		empService.deleteEmployee(id);
		
		return empService.getAllEmployees();
	}
}
