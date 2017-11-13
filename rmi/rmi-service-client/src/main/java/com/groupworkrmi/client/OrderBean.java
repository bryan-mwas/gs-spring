package com.groupworkrmi.client;

import com.groupworkrmi.client.order.Order;
import com.groupworkrmi.client.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderBean {

    @Autowired
    private OrderService orderService;

    public void placeOrder() {
        System.out.println("-- Placing orders for --");
        orderService.placeOrder("Java for dummies", 2);
        orderService.placeOrder("Springboot for dummies", 3);
        orderService.placeOrder("Time for Java", 3);
    }

    public void listOrders() {
        System.out.println("Getting order list from service");
        List<Order> orderList = orderService.getOrderList();
        System.out.println(orderList);
    }
}