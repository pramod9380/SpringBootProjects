package com.perfios.bootcamp.ecomwebsite.beans;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address_details")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String pincode;
    private String city;
    private String mobileNumber;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
