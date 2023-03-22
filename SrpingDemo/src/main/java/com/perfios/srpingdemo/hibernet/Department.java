package com.perfios.srpingdemo.hibernet;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    @Id
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "college")
    private String college;

    public Department(String name, String college) {
        this.name = name;
        this.college = college;
    }
}
