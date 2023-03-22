package com.test.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.Employees;

@Repository
@Service
public class EmpService {
	
	private static Employees empList = new Employees();
	
	static
	{
		empList.getEmpList().add(new Employee(1, "gupta", "wipro", "Blr"));
		empList.getEmpList().add(new Employee(2, "Java", "HCL", "HYD"));
		empList.getEmpList().add(new Employee(3, "SAIMOULI", "PWC", "CHN"));
		empList.getEmpList().add(new Employee(4, "VENKATA", "IBM", "PUNE"));
		empList.getEmpList().add(new Employee(5, "SANDEEP", "CTS", "KOLKATA"));
	}
	
	public Employees getAllEmployees()
	{
		return empList;
	}
	
	public void addEmployee(Employee emp)
	{
		empList.getEmpList().add(emp);
	}
	
	public String updateEmployee(Employee emp1)
	{
		for(int i = 0; i < empList.getEmpList().size(); i++)
		{
			Employee obj = empList.getEmpList().get(i);
			
			if(obj.getId().equals(emp1.getId()))
			{
				empList.getEmpList().set(i, emp1);
				
				System.out.println("one record updated");
			}
		}
		
		return "the given id is not available";
	}
	
	public String deleteEmployee(Integer id)
	{
		for(int i = 0; i < empList.getEmpList().size(); i++)
		{
			Employee obj = empList.getEmpList().get(i);
			
			if(obj.getId().equals(id))
			{
				empList.getEmpList().remove(i);
				
				System.out.println("one record deleted");
			}
		}
		
		return "the given id is not available";
	}

}
