package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.OrderItem;

public class OrderItemFactory {
    public static OrderItem createOrderItem(Long orderItemId, Long orderId, Long productId, int quantity, Double unitPrice) {

        if (orderId != null
                && productId != null
                && quantity > 0
                && unitPrice != null && unitPrice >= 0) {

            return new OrderItem.Builder()
                    .setOrderItemId(orderItemId)
                    .setOrderId(orderId)
                    .setProductId(productId)
                    .setQuantity(quantity)
                    .setUnitPrice(unitPrice)
                    .build();
        }
        return null;
    }
}
