package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.beans.MyOrder;
import com.perfios.bootcamp.ecomwebsite.exception.OrderNoFoundException;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.MyOrderServiceImpl;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("")
public class PaymentController {

    private static String orderId;

    @Autowired
    MyOrderServiceImpl myOrderService;

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", "message");
        return "welcome";
    }

    @RequestMapping("/createPayment")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException, ParseException {
        System.out.println("data >>>>>>> " + data);
        int amount = Integer.parseInt(data.get("amount").toString());

        /*
         * I am using keyId and keySecret from Test Mode if you want to use this in live
         * mode or production you have to generate key id and key secret for live mode
         */
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GP6bDr2knXr6sw", "JQ0KsJDzEOMTmT7uNfFAhkGR");

        // create order

        JSONObject options = new JSONObject();
        options.put("amount", amount*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.Orders.create(options);
        System.out.println("order  "+order);

        // fetching order id
        orderId = order.get("id");

        // saving the order details in the database

        MyOrder myOrder = new MyOrder();
        myOrder.setOrderId(order.get("id"));
        myOrder.setAmount(order.get("amount")+"");
        myOrder.setPaymentId(null);
        myOrder.setStatus("created");
//        myOrder.setUser(this.);
        myOrder.setReceipt(order.get("receipt"));

        // unix seconds
        Date date = order.get("created_at");
        myOrder.setDate(date);
        myOrderService.saveOrder(myOrder);

        return order.toString();
    }

    @GetMapping("/orderPlaced")
    public String getOrderPlacedPage(Model model) throws OrderNoFoundException {
        model.addAttribute("orderDetails", myOrderService.getOrderByOrderId(orderId));
        return "orderPlaced";
    }

    @PostMapping("/orderPlaced")
    public String postOrderPlaced(){
        return "index";
    }
}
