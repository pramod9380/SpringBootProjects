package com.test.model;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class EmpDao {
	
	private static Employees emp = new Employees();
	
	static {
		
		emp.getEmpList().add(new Employee(101, "Spring", "MPL"));
		emp.getEmpList().add(new Employee(102, "Hero", "Blr"));
		emp.getEmpList().add(new Employee(103, "King", "TPT"));
		emp.getEmpList().add(new Employee(104, "Java", "chn"));
		emp.getEmpList().add(new Employee(105, "APPLE", "Hyd"));
		emp.getEmpList().add(new Employee(106, "Dilip", "ctm"));
	}
	
	//list all employees
	
	public Employees getAllEmployees()
	{
		return emp;
	}
	
	public void addEmployee(Employee emp1)
	{
		emp.getEmpList().add(emp1);
	}
	
	public String updateEmployee(Employee emp1)
	{
		for(int i = 0; i < emp.getEmpList().size(); i++)
		{
			Employee emp2 = emp.getEmpList().get(i);
			
			if(emp2.getId().equals(emp1.getId()))
			{
				emp.getEmpList().set(i, emp1);
				
				System.out.println("one record updated");
			}
		}
		
		return "the given id is not available";
	}
	
	public String deleteEmployee(Integer id)
	{
		for(int i = 0; i < emp.getEmpList().size(); i++)
		{
			Employee emp1 = emp.getEmpList().get(i);
			
			if(emp1.getId().equals(id))
			{
				emp.getEmpList().remove(i);
			}
		}
		
		return "the given id is not available";
	}

}
