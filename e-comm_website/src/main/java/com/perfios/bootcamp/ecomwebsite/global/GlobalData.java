package com.perfios.bootcamp.ecomwebsite.global;

import com.perfios.bootcamp.ecomwebsite.beans.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<>();
    }
}
