package com.groupworkrmi.service.order;

import java.util.List;

public interface OrderService{

    void placeOrder(String item, int quantity);

    List<Order> getOrderList();

}