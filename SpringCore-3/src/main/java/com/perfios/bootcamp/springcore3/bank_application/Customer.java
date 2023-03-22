package com.perfios.bootcamp.springcore3.bank_application;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
public class Customer implements CustomerDetails {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String dob;
    private String mobileNumber;
    private String emailId;
    @Autowired
    private Address address;


//    public Customer(Address address){
//        this.address = address;
//    }


    @Override
    public void getDetails() {
        System.out.println("Customer Details:" +
                "\nId: "+id+
                "\nFirst Name: "+firstName+
                "\nLast Name: "+lastName+
                "\nGender: "+gender+
                "\nAge: "+age+
                "\nDob: "+dob+
                "\nMobile Number: "+mobileNumber+
                "\nEmail Id: "+emailId+
                "\nAddress: "+address
                );
    }
}
