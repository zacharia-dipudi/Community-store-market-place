package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Order;
import za.ac.cput.communitystoremarketplace.Repository.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean delete(Long orderId) {
        orderRepository.deleteById(orderId);
        return true;
    }
}
