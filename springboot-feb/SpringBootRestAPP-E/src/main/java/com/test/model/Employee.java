package com.test.model;

public class Employee {
	
	private Integer id;
	
	private String name;
	
	private String cmp;
	
	private String city;
	
	public Employee()
	{
		
	}

	public Employee(Integer id, String name, String cmp, String city) {
		
		this.id = id;
		this.name = name;
		this.cmp = cmp;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
