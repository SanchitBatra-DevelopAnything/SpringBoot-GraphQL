package com.example.graphQLLesson.demo.Services;

import com.example.graphQLLesson.demo.Entities.Order;

import com.example.graphQLLesson.demo.Helper.ExceptionHandler;
import com.example.graphQLLesson.demo.Repository.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(Order order)
    {
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders()
    {
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId)
    {
        return orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    public boolean deleteOrder(int orderId)
    {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

    ///update order todo.
}
