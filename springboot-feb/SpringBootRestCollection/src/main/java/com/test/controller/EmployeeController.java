package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.EmpDao;
import com.test.model.Employee;
import com.test.model.Employees;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpDao empDao;

	@GetMapping(path = "/", produces = "application/json")
	public Employees getAllEmployees()
	{
		return empDao.getAllEmployees();
	}
	
	@PostMapping(path = "/", consumes = "application/json")
	public Employees addEmployee(@RequestBody Employee emp)
	{
		int id = empDao.getAllEmployees().getEmpList().size() + 1;
		
		emp.setId(id);
		
		empDao.addEmployee(emp);
		
		return empDao.getAllEmployees();
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json")
	public Employees updateEmployee(@RequestBody Employee emp, @PathVariable("id") Integer id)
	{
		emp.setId(id);
		
		empDao.updateEmployee(emp);
		
		return empDao.getAllEmployees();
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public Employees deleteEmployee(@PathVariable("id") Integer id)
	{
		empDao.deleteEmployee(id);
		
		return empDao.getAllEmployees();
	}
}
