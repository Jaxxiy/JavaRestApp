package com.example.lab3.services;

import com.example.lab3.models.Order;
import com.example.lab3.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findById(int id) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }else{
            System.out.println("Order not found");
            return null;
        }
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(int id, String doctorSurname, String payWay) {
        Order order = orderRepository.findById(id).get();
        order.setDoctorSurname(doctorSurname);
        order.setPayWay(payWay);
        orderRepository.save(order);
    }
}
