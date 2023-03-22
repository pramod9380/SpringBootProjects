package com.example.springbootrestapi.beans;

public class Employee {

    private int id;
    private String name;
    private String company;
    private String city;

    public Employee(int id, String name, String company, String city) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.city = city;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
