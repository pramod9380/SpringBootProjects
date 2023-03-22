package com.perfios.bootcamp.ecomwebsite.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String userName;
    private String password;
    private String emailId;
    private String mobileNumber;
    private boolean active = true;
    private String role = "ROLE_USER";
}
