package za.ac.cput.communitystoremarketplace.Factory;


import za.ac.cput.communitystoremarketplace.Domain.Order;
import za.ac.cput.communitystoremarketplace.util.Helper;

import java.util.Date;

public class OrderFactory {
    public static Order createOrder(Long orderId, Double totalAmount, Date orderDate, String orderStatus, Long buyerId, String paymentStatus, String notes) {


        if (!Helper.isNullorEmpty(orderStatus)
                && !Helper.isNullorEmpty(paymentStatus)
                && !Helper.isNullorEmpty(notes)) {


            return new Order.Builder()
                    .setOrderId(orderId)
                    .setTotalAmount(totalAmount)
                    .setOrderDate(orderDate)
                    .setOrderStatus(orderStatus)
                    .setBuyerId(buyerId)
                    .setPaymentStatus(paymentStatus)
                    .setNotes(notes)
                    .build();
        }
        return null;
    }
}
