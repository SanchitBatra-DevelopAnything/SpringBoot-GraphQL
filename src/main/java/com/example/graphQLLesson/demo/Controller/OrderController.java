package com.example.graphQLLesson.demo.Controller;

import com.example.graphQLLesson.demo.Entities.Order;
import com.example.graphQLLesson.demo.Services.OrderService;
import com.example.graphQLLesson.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetail , @Argument String address , @Argument int price , @Argument int userId)
    {
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(userService.getUser(userId));

        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders()
    {
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId)
    {
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId)
    {
        return orderService.deleteOrder(orderId);
    }
}
