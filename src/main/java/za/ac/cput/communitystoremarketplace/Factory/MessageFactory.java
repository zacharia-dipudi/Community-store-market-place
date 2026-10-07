package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Message;
import za.ac.cput.communitystoremarketplace.util.Helper;

import java.util.Date;

public class MessageFactory {
    public static Message createMessage(Long messageId, Long senderId, Long receiverId, Long productId, String messageContent, Date messageDate, boolean messageRead) {

        if (senderId != null
                && receiverId != null
                && !senderId.equals(receiverId)
                && !Helper.isNullorEmpty(messageContent)) {

            return new Message.Builder()
                    .setMessageId(messageId)
                    .setSenderId(senderId)
                    .setReceiverId(receiverId)
                    .setProductId(productId)
                    .setMessageContent(messageContent)
                    .setMessageDate(messageDate != null ? messageDate : new Date())
                    .setMessageRead(messageRead)
                    .build();
        }
        return null;
    }
}
