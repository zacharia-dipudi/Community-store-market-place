package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.OrderItem;
import za.ac.cput.communitystoremarketplace.Service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem) {
        return orderItemService.create(orderItem);
    }

    @GetMapping("/read")
    public OrderItem read(@RequestParam Long orderItemId) {
        return orderItemService.read(orderItemId);
    }

    @PutMapping("/update")
    public OrderItem update(@RequestBody OrderItem orderItem) {
        return orderItemService.update(orderItem);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long orderItemId) {
        return orderItemService.delete(orderItemId);
    }

    @GetMapping("/getAll")
    public List<OrderItem> getAll() {
        return orderItemService.getAll();
    }

    @GetMapping("/getByOrder")
    public List<OrderItem> getByOrder(@RequestParam Long orderId) {
        return orderItemService.getByOrderId(orderId);
    }
}
