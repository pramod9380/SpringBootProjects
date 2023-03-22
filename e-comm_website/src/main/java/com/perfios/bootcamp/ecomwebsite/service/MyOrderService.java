package com.perfios.bootcamp.ecomwebsite.service;

import com.perfios.bootcamp.ecomwebsite.beans.MyOrder;
import com.perfios.bootcamp.ecomwebsite.exception.OrderNoFoundException;

import java.util.List;

public interface MyOrderService {

    List<MyOrder> getAllOrder();
    MyOrder getOrderById(int id) throws OrderNoFoundException;
    void saveOrder(MyOrder order);
    void deleteOrderById(int id) throws OrderNoFoundException;
    void deleteAllOrders();

    MyOrder getOrderByOrderId(String id) throws OrderNoFoundException;

}
