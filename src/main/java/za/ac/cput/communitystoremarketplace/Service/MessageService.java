package za.ac.cput.communitystoremarketplace.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.communitystoremarketplace.Domain.Message;
import za.ac.cput.communitystoremarketplace.Repository.MessageRepository;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getInbox(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Message> getSent(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    @Override
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message read(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    @Override
    public Message update(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public boolean delete(Long messageId) {
        messageRepository.deleteById(messageId);
        return true;
    }
}
