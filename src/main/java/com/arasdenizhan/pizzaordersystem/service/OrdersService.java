package com.arasdenizhan.pizzaordersystem.service;

import com.arasdenizhan.pizzaordersystem.model.Orders;

import java.util.List;

public interface OrdersService {
    Orders addNewOrder(Orders orders);
    Orders getOrderById(Long id);
    Orders deleteOrderById(Long id);
    List<Orders> searchOrderByType(String type);
    List<Orders> getAllOrders();
}
