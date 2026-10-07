package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Message;

import java.util.List;

public interface IMessageService extends IService<Message, Long> {
    List<Message> getAll();
    List<Message> getInbox(Long receiverId);
    List<Message> getSent(Long senderId);
}
