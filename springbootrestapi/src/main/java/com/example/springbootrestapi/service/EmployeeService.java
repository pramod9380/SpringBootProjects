package com.example.springbootrestapi.service;

import com.example.springbootrestapi.beans.Employee;
import com.example.springbootrestapi.beans.Employees;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Repository
public class EmployeeService {

    private static Employees employees = new Employees();

    static
    {
        List<Employee> employeeList = employees.getEmployees();
        Collections.addAll(employeeList,
                new Employee(1,"Pramod","Perfios","Bangalore"),
                new Employee(2,"Pavan","Perfios","Bangalore"),
                new Employee(3,"Nandan","Shell","Bangalore"),
                new Employee(4,"Aditya","Paytm","Pune")
        );
    }

    // CRUD Operations

    // adding the employee data
    public void saveEmployee(Employee employee){
        employees.getEmployees().add(employee);
    }

    // read employee data
    public Employees getAllEmployees(){
        return employees;
    }

    // update employee data
    public String updateEmployee(Employee employee){

        for(int i=0;i<employees.getEmployees().size();i++){

            Employee employee1 = employees.getEmployees().get(i);

            if(employee1.getId() == employee.getId()){
                employees.getEmployees().set(i,employee);
            }
        }

        return "The given id is not available";
    }

    public String deleteEmployee(int id){

        employees.getEmployees().stream().filter(emp->emp.getId()==id).collect(Collectors.toList()).remove(0);

//        for(int i=0; i<employees.getEmployees().size();i++){
//            Employee employee = employees.getEmployees().get(i);
//            if(employee.getId() == id){
//                employees.getEmployees().remove(i);
//            }
//        }
        return "The given id not available";

    }

}
