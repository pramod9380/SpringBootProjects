package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.MyOrder;
import com.perfios.bootcamp.ecomwebsite.exception.OrderNoFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.OrderRepository;
import com.perfios.bootcamp.ecomwebsite.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyOrderServiceImpl implements MyOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<MyOrder> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public MyOrder getOrderById(int id) throws OrderNoFoundException {
        orderRepository.findById(id).orElseThrow(()->new OrderNoFoundException("Order Not found with this id, Please enter a valid order id!!"));
        return orderRepository.findById(id).get();
    }

    @Override
    public void saveOrder(MyOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(int id) throws OrderNoFoundException {
        orderRepository.findById(id).orElseThrow(()->new OrderNoFoundException("Order Not found with this id, Please enter a valid order id!!"));
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @Override
    public MyOrder getOrderByOrderId(String id) throws OrderNoFoundException {
        orderRepository.findByOrderId(id).orElseThrow(()->new OrderNoFoundException("Order Not found with this id, Please enter a valid order id!!"));
        return orderRepository.findByOrderId(id).get();
    }
}
