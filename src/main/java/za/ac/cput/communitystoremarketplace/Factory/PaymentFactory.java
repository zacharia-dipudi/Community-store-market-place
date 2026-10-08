package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Payment;
import za.ac.cput.communitystoremarketplace.util.Helper;
import java.time.LocalDateTime;

public class PaymentFactory{
    public static Payment createPayment( Long paymentId,Long orderId, Long userId, Double amount, String paymentMethod, String paymentStatus, LocalDateTime transactionDate, String transactionReference){
        if (paymentId != null
            && orderId!= null
            && userId != null
            && !Helper.isNullorEmpty(paymentMethod)
            && !Helper.isNullorEmpty(paymentStatus)
            && transactionDate != null
            && !Helper.isNullorEmpty(transactionReference)
                ){
            
    return new Payment.Builder() 
            .setPaymentId(paymentId) 
            .setOrderId(orderId) 
            .setUserId(userId) 
            .setAmount(amount) 
            .setPaymentMethod(paymentMethod) 
            .setPaymentStatus(paymentStatus) 
            .setTransactionDate(transactionDate) 
            .setTransactionReference(transactionReference) 
            .build(); } return null; 
    }
   
}
