package com.perfios.srpingdemo.dependencyinjuction;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Employee {

    private String employeeName;
    private int employeeId;

    @Autowired
    private Address address;

    // HAS-A

 /*
    // Tightly coupled
    public Employee(){
        address = new Address();
    }
 */

    //Loosely coupled
    public Employee(Address address){
        this.address=address;
    }

    public void setAddress(Address address){
        this.address=address;
    }
}
