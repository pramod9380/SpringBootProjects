package com.example.springbootformvalidations.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    @Size(min = 3, max = 10)
    @NotEmpty(message = "username required")
    private String userName;
    @NotEmpty(message = "password required")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
