package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.OrderItem;

import java.util.List;

public interface IOrderItemService extends IService<OrderItem, Long> {
    List<OrderItem> getAll();
    List<OrderItem> getByOrderId(Long orderId);
}
