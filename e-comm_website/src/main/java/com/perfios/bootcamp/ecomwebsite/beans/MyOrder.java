package com.perfios.bootcamp.ecomwebsite.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_details")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String orderId;
    private String amount;
    private String receipt;
    private Date date;
    private String paymentId;
    private String status;

    @ManyToOne
    private User user;
}
