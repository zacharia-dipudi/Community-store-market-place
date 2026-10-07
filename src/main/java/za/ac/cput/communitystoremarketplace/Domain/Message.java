package za.ac.cput.communitystoremarketplace.Domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private Long senderId;
    private Long receiverId;
    private Long productId; // optional: message about a specific product
    @Column(length = 2000)
    private String messageContent;
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageDate;
    private boolean messageRead;

    public Message(Long messageId, Long senderId, Long receiverId, Long productId, String messageContent, Date messageDate, boolean messageRead) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.productId = productId;
        this.messageContent = messageContent;
        this.messageDate = messageDate;
        this.messageRead = messageRead;
    }

    private Message(Builder builder) {
        this.messageId = builder.messageId;
        this.senderId = builder.senderId;
        this.receiverId = builder.receiverId;
        this.productId = builder.productId;
        this.messageContent = builder.messageContent;
        this.messageDate = builder.messageDate;
        this.messageRead = builder.messageRead;
    }

    public Message() {
    }

    public Long getMessageId() { return messageId; }
    public void setMessageId(Long messageId) { this.messageId = messageId; }

    public Long getSenderId() { return senderId; }
    public void setSenderId(Long senderId) { this.senderId = senderId; }

    public Long getReceiverId() { return receiverId; }
    public void setReceiverId(Long receiverId) { this.receiverId = receiverId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getMessageContent() { return messageContent; }
    public void setMessageContent(String messageContent) { this.messageContent = messageContent; }

    public Date getMessageDate() { return messageDate; }
    public void setMessageDate(Date messageDate) { this.messageDate = messageDate; }

    public boolean isMessageRead() { return messageRead; }
    public void setMessageRead(boolean messageRead) { this.messageRead = messageRead; }

    public static class Builder {
        private Long messageId;
        private Long senderId;
        private Long receiverId;
        private Long productId;
        private String messageContent;
        private Date messageDate;
        private boolean messageRead;

        public Builder setMessageId(Long messageId) {
            this.messageId = messageId;
            return this;
        }
        public Builder setSenderId(Long senderId) {
            this.senderId = senderId;
            return this;
        }
        public Builder setReceiverId(Long receiverId) {
            this.receiverId = receiverId;
            return this;
        }
        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }
        public Builder setMessageContent(String messageContent) {
            this.messageContent = messageContent;
            return this;
        }
        public Builder setMessageDate(Date messageDate) {
            this.messageDate = messageDate;
            return this;
        }
        public Builder setMessageRead(boolean messageRead) {
            this.messageRead = messageRead;
            return this;
        }
        public Message build() {
            return new Message(this);
        }
    }
}
