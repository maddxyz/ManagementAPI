package com.example.managmentapi.Order;

import com.example.managmentapi.Business.BusinessRepository;
import com.example.managmentapi.Business.BusinessService;
import com.example.managmentapi.Product.ProductRepository;
import com.example.managmentapi.Product.ProductService;
import com.example.managmentapi.manager.ManagerService;
import com.example.managmentapi.manager.ManagerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
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
