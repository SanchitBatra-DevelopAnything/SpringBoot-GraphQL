package com.example.graphQLLesson.demo.Repository;

import com.example.graphQLLesson.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
