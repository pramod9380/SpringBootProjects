package com.example.springbatch;

import lombok.Data;

@Data
public class Product {

    private int id;
    private String prodCode;
    private double prodCost;

    private double prodDisc;
    private double proGst;
}
