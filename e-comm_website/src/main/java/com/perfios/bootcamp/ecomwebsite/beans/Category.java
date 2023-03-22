package com.perfios.bootcamp.ecomwebsite.beans;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category_details")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String categoryDescription;
}
