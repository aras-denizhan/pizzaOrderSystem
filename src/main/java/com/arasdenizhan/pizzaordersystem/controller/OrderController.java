package com.arasdenizhan.pizzaordersystem.controller;

import com.arasdenizhan.pizzaordersystem.model.Orders;
import com.arasdenizhan.pizzaordersystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class OrderController {

    private final Logger logger = Logger.getLogger(OrderController.class.getName());

    private final OrdersService ordersService;

    @Autowired
    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public String homepage(Model model){
        model.addAttribute("orderstest", new Orders());
        return "order";
    }

    @GetMapping("/order")
    public String order(Model model){
        model.addAttribute("orderstest", new Orders());
        return "order";
    }

    @PostMapping("/order")
    public Orders addNewOrder(@ModelAttribute("orderstest") Orders orders){
        Objects.requireNonNull(orders);
        return ordersService.addNewOrder(orders);
    }

    @GetMapping("/orderlist")
    public String orderlist(Model model){
        model.addAttribute("allorders", ordersService.getAllOrders());
        return "orderlist";
    }

    @GetMapping("/orderlist/{pizzaType}")
    public String orderlistByType(Model model, @PathVariable String pizzaType){
        model.addAttribute("allorders", ordersService.searchOrderByType(pizzaType));
        return "orderlist";
    }

    @GetMapping("/orderDelete/{orderid}")
    public String deleteOrder(Model model, @PathVariable Long orderid){
        ordersService.deleteOrderById(orderid);
        model.addAttribute("allorders", ordersService.getAllOrders());
        return "orderlist";
    }
}
