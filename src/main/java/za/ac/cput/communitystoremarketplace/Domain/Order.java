package za.ac.cput.communitystoremarketplace.Domain;

import java.util.Date;

public class Order {
    private Long orderId;
    private Double totalAmount;
    private Date orderDate;
    private String orderStatus;
    private Long buyerId;
    private String paymentStatus;
    private String notes;

    public Order(Long orderId, Double totalAmount, Date orderDate, String orderStatus, Long buyerId, String paymentStatus, String notes){
        this.orderId=orderId;
        this.totalAmount=totalAmount;
        this.orderDate=orderDate;
        this.orderStatus=orderStatus;
        this.buyerId=buyerId;
        this.paymentStatus=paymentStatus;
        this.notes=notes;
    }

    private Order(Builder builder){
        this.orderId=builder.orderId;
        this.totalAmount=builder.totalAmount;
        this.orderDate=builder.orderDate;
        this.orderStatus=builder.orderStatus;
        this.buyerId=builder.buyerId;
        this.paymentStatus=builder.paymentStatus;
        this.notes=builder.notes;
    }
    public Order(){
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static class Builder{
        private Long orderId;
        private Double totalAmount;
        private Date orderDate;
        private String orderStatus;
        private Long buyerId;
        private String paymentStatus;
        private String notes;

        public Builder setOrderId(Long orderId){
            this.orderId=orderId;
            return this;
        }
        public Builder setTotalAmount(Double totalAmount){
            this.totalAmount=totalAmount;
            return this;
        }
        public Builder setOrderDate(Date orderDate){
            this.orderDate=orderDate;
            return this;
        }
        public Builder setOrderStatus(String orderStatus){
            this.orderStatus=orderStatus;
            return this;
        }
        public Builder setBuyerId(Long buyerId){
            this.buyerId=buyerId;
            return this;
        }
        public Builder setPaymentStatus(String paymentStatus){
            this.paymentStatus=paymentStatus;
            return this;
        }
        public Builder setNotes(String notes){
            this.notes=notes;
            return this;
        }
        public Order build(){
          return new Order(this);
        }
    }


}
