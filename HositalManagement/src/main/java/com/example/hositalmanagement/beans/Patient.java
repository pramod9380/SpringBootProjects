package com.example.hositalmanagement.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
