package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	
	private List<Employee> empList;

	public List<Employee> getEmpList() {
		
		if(empList == null)
		{
			empList = new ArrayList<Employee>();
		}
		
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
