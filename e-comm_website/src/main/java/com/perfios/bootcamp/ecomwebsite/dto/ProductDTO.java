package com.perfios.bootcamp.ecomwebsite.dto;

import lombok.Data;


@Data
public class ProductDTO {

    private int id;
    private String name;
    private String description;
    private int price;
    private int discount;
    private String image;
    private int categoryId;

}
