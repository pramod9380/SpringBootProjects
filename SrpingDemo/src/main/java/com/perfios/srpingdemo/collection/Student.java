package com.perfios.srpingdemo.collection;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private List<String> course;
    private List<College> colleges;

}
