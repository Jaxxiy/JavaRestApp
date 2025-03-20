package com.example.lab3.controllers;

import com.example.lab3.models.Order;
import com.example.lab3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/orders")
@RestController
public class OrderController {

    public OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.findById(id);
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam String doctorSurname, @RequestParam String payWay) {
        Order order = new Order(doctorSurname, payWay);
        orderService.createOrder(order);
        return "created successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteById(id);
        return "deleted successfully";
    }

    @PatchMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestParam String doctorSurname, @RequestParam String payWay) {
        orderService.updateOrder(id,doctorSurname,payWay);
        return "updated successfully";
    }

}
