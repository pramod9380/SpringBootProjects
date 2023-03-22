package com.perfios.srpingdemo.spring_hibernate_integration;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Course {

    @Id

    private int id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_duration")
    private String duration;

    @Column(name = "course_price")
    private int price;
}
