package za.ac.cput.communitystoremarketplace.Domain;
import java.time.LocalDateTime;

public class Payment {
    private Long paymentId;      
    private Long orderId;
    private Long userId;
    private Double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime transactionDate;
    private String transactionReference;
    
public Payment(Long paymentId, Long orderId, Long userId, Double amount, String paymentMethod,String paymentStatus, LocalDateTime transactionDate, String transactionReference){
    this.paymentId= paymentId;
    this.orderId=orderId;
    this.userId= userId;
    this.amount= amount;
    this.paymentMethod= paymentMethod;
    this.paymentStatus= paymentStatus;
    this.transactionDate= transactionDate;
    this.transactionReference= transactionReference;
}

public Payment(Builder builder){
    this.paymentId= builder.paymentId;
    this.orderId= builder.orderId;
    this.userId= builder.userId;
    this.amount= builder.amount;
    this.paymentMethod= builder.paymentMethod;
    this.paymentStatus= builder.paymentStatus;
    this.transactionDate= builder.transactionDate;
    this.transactionReference= builder.transactionReference;
}

    public Long getPaymentId() {
        return paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public static class Builder{
        private Long paymentId;
        private Long orderId;
        private Long userId;
        private Double amount;
        private String paymentMethod;
        private String paymentStatus;
        private LocalDateTime transactionDate;
        private String transactionReference;

        public Builder setPaymentId(Long paymentId){
            this.paymentId=paymentId;
            return this;
        }
    
        public Builder setOrderId(Long orderId){
            this.orderId=orderId;
            return this;
            }
    
        public Builder setUserId(Long userId){
            this.userId= userId;
            return this;
        }
        
        public Builder setAmount(Double amount){
            this.amount= amount;
            return this;
            }
        
        public Builder setPaymentMethod(String paymentMethod){
            this.paymentMethod= paymentMethod;
            return this;            
        }
        
        public Builder setPaymentStatus(String paymentStatus){
            this.paymentStatus= paymentStatus;
            return this;
        }
        
        public Builder setTransactionDate(LocalDateTime transactionDate){
            this.transactionDate= transactionDate;
            return this;
        }
        
        public Builder setTransactionReference(String transactionReference){
            this.transactionReference= transactionReference;
            return this;
        }
        
        public Payment build(){
            return new Payment(this);
        }
        
    }   
}
