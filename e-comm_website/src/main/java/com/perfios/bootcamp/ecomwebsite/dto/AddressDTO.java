package com.perfios.bootcamp.ecomwebsite.dto;


import lombok.Data;

@Data
public class AddressDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String pincode;
    private String city;
    private String mobileNumber;
    private String email;
    private int userId;

}
