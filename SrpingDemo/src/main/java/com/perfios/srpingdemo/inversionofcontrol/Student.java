package com.perfios.srpingdemo.inversionofcontrol;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private String studentName;
    private String studentUsn;
    private String studentLocation;

    public void myInit(){
        System.out.println("Student object initialized!!!!");
    }

    public void myDestroy(){
        System.out.println("Student object destroyed!!!!!!");
    }
}
