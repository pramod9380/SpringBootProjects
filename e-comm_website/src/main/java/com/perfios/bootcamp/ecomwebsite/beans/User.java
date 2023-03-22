package com.perfios.bootcamp.ecomwebsite.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;

    @Transient
    private String confirmPassword;

    @Column(unique = true)
    private String emailId;
    private String mobileNumber;
    private boolean active;
    private String roles;

}
