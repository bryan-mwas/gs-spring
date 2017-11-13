package com.groupworkrmi.service;

import com.groupworkrmi.service.order.Order;
import com.groupworkrmi.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "orderService", endpointInterface = "com.groupworkrmi.service")
@Service
public class OrderServiceImpl implements OrderService {
    private List<Order> orders = new ArrayList<>();

    @Override
    @WebMethod
    public void placeOrder(String item, int quantity) {
        Order order = new Order();
        order.setItem(item);
        order.setQty(quantity);
        order.setOrderDate(LocalDateTime.now());
        System.out.println("Placing order: "+order);
        orders.add(order);
    }

    @Override
    @WebMethod
    public List<Order> getOrderList() {
        return new ArrayList<>(orders);
    }
}