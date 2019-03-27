package com.example.managmentapi.Order;

import com.example.managmentapi.Business.BusinessRepository;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BusinessRepository businessRepository;

    public Orders getOrder(Integer id) {
        return orderRepository.findById(id).orElse(new Orders());
    }

    public List<Orders> getOrders(Integer idBusiness){
        List<Product> products = productRepository.findByBusiness(businessRepository.findById(idBusiness).get());

        Set<Orders> orders = new HashSet<>();

        for(Product p : products) {
            for(Orders o : p.getOrders()) {
                orders.add(o);
            }
        }

        return new ArrayList<>(orders);
    }

    public Integer edit(Integer id, Orders orders) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.delete(orderRepository.findById(id).get());
            orders.setId(id);
            return orderRepository.save(orders).getId();
        }
        else return -1;
    }

    public Orders add(Orders orders) {
        return orderRepository.save(orders);
    }


    public void delete(Orders orders) {
        orderRepository.delete(orders);
    }

    /* Here is the status codes :

        0) i want this (waiting)
        2) business accepted it
        1) ready !
        -1) no tacos for you.
     */
    public void markReady(Orders orders) {
        orders.setStatus(1);
        orderRepository.save(orders);
    }

    public void acceptOrder(Orders orders) {
        orders.setStatus(2);
        orderRepository.save(orders);
    }

    public void refuseOrder(Orders orders) {
        orders.setStatus(-1);
        orderRepository.save(orders);
    }

    public void payOrder(Orders orders) {
        orders.setPaid(1);
        orderRepository.save(orders);
    }

    public void unpayOrder(Orders orders) {
        orders.setPaid(0);
        orderRepository.save(orders);
    }
}
