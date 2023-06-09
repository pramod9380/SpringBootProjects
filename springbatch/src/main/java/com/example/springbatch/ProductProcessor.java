package com.example.springbatch;

import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        double cost = item.getProdCost();
        item.setProdDisc(cost * 12/100.0);
        item.setProGst(cost * 22/100.0);
        return item;
    }
}
