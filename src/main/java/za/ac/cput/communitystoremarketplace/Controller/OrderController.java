package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Order;
import za.ac.cput.communitystoremarketplace.Service.OrderService;

import java.util.List;

public class OrderController {
    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @PostMapping("/create")
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }
    @GetMapping("/read")
    public Order read(@RequestParam Long orderId){
        return orderService.read(orderId);
    }
    @PutMapping("/update")
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long orderId){
        orderService.delete(orderId);
        return true;
    }
    List<Order>getAll(){
        return orderService.getAll();
    }
}
