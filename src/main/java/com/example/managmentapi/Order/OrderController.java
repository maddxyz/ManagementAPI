package com.example.managmentapi.Order;

import com.example.managmentapi.Business.BusinessRepository;
import com.example.managmentapi.Business.BusinessService;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductController;
import com.example.managmentapi.Product.ProductRepository;
import com.example.managmentapi.Product.ProductService;
import com.example.managmentapi.manager.ManagerService;
import com.example.managmentapi.manager.ManagerRepository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final ManagerService managerService;
    private final ManagerRepository managerRepository;
    private final BusinessRepository businessRepository;
    private final BusinessService businessService;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public OrderController(OrderService orderService, OrderRepository orderRepository, ManagerService managerService,
                           ManagerRepository managerRepository, BusinessRepository businessRepository, BusinessService businessService,
                           ProductRepository productRepository, ProductService productService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.managerService = managerService;
        this.managerRepository = managerRepository;
        this.businessRepository = businessRepository;
        this.businessService = businessService;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/order/{id}")
    public Order fetchOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/orders/{idBusiness}")
    public List<Order> fetchOrders(@PathVariable Integer idBusiness) {
        return orderService.getOrders(idBusiness);
    }


    @PostMapping("/order")
    public Integer addOrder(@RequestBody Order order) {
        return orderService.add(order).getId();
    }

    @PostMapping("/order/{id}")
    public Integer editOrder(@RequestBody Order order, @PathVariable("id") Integer id) {
        return orderService.edit(id, order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.delete(orderRepository.findById(id).get());

    }

    @GetMapping("/order/{id}/mark_ready")
    public void markReady(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.markReady(orderRepository.findById(id).get());
    }

    @GetMapping("/order/{id}/accept")
    public void acceptOrder(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.acceptOrder(orderRepository.findById(id).get());
    }

    @GetMapping("/order/{id}/refuse")
    public void refuseOrder(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.refuseOrder(orderRepository.findById(id).get());
    }

    @GetMapping("/order/{id}/pay")
    public void payOrder(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.payOrder(orderRepository.findById(id).get());
    }

    @GetMapping("/order/{id}/unpay")
    public void unpayOrder(@PathVariable("id") Integer id) {
        if (orderRepository.findById(id).isPresent())
            orderService.unpayOrder(orderRepository.findById(id).get());
    }
}
