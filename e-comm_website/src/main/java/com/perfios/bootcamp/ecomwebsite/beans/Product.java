package com.perfios.bootcamp.ecomwebsite.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_desc")
    private String description;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_discount")
    private int discount;

    @Column(name = "product_image")
    private String image;

    // Lazy helps to find the only required columns after joining the tables
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;

}
