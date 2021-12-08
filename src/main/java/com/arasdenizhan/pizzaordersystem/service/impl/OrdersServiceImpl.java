package com.arasdenizhan.pizzaordersystem.service.impl;

import com.arasdenizhan.pizzaordersystem.model.Orders;
import com.arasdenizhan.pizzaordersystem.repository.OrdersRepository;
import com.arasdenizhan.pizzaordersystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    @Override
    public Orders addNewOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrderById(Long id) {
        if(ordersRepository.existsById(id)){
            return ordersRepository.getById(id);
        }
        return null;
    }

    @Override
    public void deleteOrderById(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public List<Orders> searchOrderByType(String type) {
        return ordersRepository.getOrdersByType(type);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}
