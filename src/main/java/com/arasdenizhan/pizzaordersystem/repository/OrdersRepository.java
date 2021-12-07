package com.arasdenizhan.pizzaordersystem.repository;

import com.arasdenizhan.pizzaordersystem.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT * FROM ORDERS WHERE PIZZA_TYPE=?1", nativeQuery = true)
    public List<Orders> getOrdersByType(String type);
}
