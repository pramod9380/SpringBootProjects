package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	
	private List<Employee> listEmp = null;

	public List<Employee> getListEmp() {
		
		if(listEmp == null)
		{
			listEmp = new ArrayList<Employee>();
		}
		return listEmp;
	}

	public void setListEmp(List<Employee> listEmp) {
		this.listEmp = listEmp;
	}

	
}
