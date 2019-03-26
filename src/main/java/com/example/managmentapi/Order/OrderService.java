package com.example.managmentapi.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Integer id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    public List<Order> getOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Integer edit(Integer id, Order order) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.delete(orderRepository.findById(id).get());
            order.setId(id);
            return orderRepository.save(order).getId();
        }
        else return -1;
    }

    public Order add(Order order) {
        return orderRepository.save(order);
    }


    public void delete(Order order) {
        orderRepository.delete(order);
    }

    /* Here is the status codes :

        0) i want this (waiting)
        2) business accepted it
        1) ready !
        -1) no tacos for you.
     */
    public void markReady(Order order) {
        order.setStatus(1);
        orderRepository.save(order);
    }

    public void acceptOrder(Order order) {
        order.setStatus(2);
        orderRepository.save(order);
    }

    public void refuseOrder(Order order) {
        order.setStatus(-1);
        orderRepository.save(order);
    }

    public void payOrder(Order order) {
        order.setPaid(1);
        orderRepository.save(order);
    }

    public void unpayOrder(Order order) {
        order.setPaid(0);
        orderRepository.save(order);
    }
}
