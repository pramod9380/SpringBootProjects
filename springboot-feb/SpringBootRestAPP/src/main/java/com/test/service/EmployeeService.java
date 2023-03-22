package com.test.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.Employees;

@Repository
@Service
public class EmployeeService {
	
	private static Employees empList = new Employees();
	
	static
	{
		empList.getListEmp().add(new Employee(101, "gupta", "CTS", "Blr"));
		empList.getListEmp().add(new Employee(102, "sandeep", "e y", "hyd"));
		empList.getListEmp().add(new Employee(103, "nikhil", "pwc", "chn"));
		empList.getListEmp().add(new Employee(104, "hero", "ibm", "pune"));
		empList.getListEmp().add(new Employee(105, "java", "wipro", "kolkata"));
	}
	
	public Employees getAllEmployees()
	{
		return empList;
	}
	
	public void addEmployees(Employee emp)
	{
		empList.getListEmp().add(emp);
	}
	
	public String updateEmployee(Employee emp1)
	{
		for(int i = 0; i<empList.getListEmp().size(); i++)
		{
			Employee emp = empList.getListEmp().get(i);
			
			if(emp1.getId().equals(emp.getId()))
			{
				empList.getListEmp().set(i, emp1);
				System.out.println("one record updated");
			}
		}
		
		return "the givne id is not available";
	}
	
	public String deleteEmployee(Integer id)
	{
		for(int i = 0; i<empList.getListEmp().size(); i++)
		{
			Employee emp = empList.getListEmp().get(i);
			
			if(emp.getId().equals(id))
			{
				empList.getListEmp().remove(i);
				System.out.println("one record deleted.");
			}
		}
		
		return "the givne id is not available";
	}

}
