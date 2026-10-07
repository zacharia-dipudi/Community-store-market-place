package za.ac.cput.communitystoremarketplace.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private int quantity;
    private Double unitPrice; // price snapshot at time of purchase

    public OrderItem(Long orderItemId, Long orderId, Long productId, int quantity, Double unitPrice) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    private OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.orderId = builder.orderId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    public OrderItem() {
    }

    public Long getOrderItemId() { return orderItemId; }
    public void setOrderItemId(Long orderItemId) { this.orderItemId = orderItemId; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }

    @Transient
    public Double getSubtotal() {
        return unitPrice == null ? 0.0 : unitPrice * quantity;
    }

    public static class Builder {
        private Long orderItemId;
        private Long orderId;
        private Long productId;
        private int quantity;
        private Double unitPrice;

        public Builder setOrderItemId(Long orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }
        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }
        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }
        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public Builder setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }
        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
