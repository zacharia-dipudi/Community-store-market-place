package za.ac.cput.communitystoremarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.communitystoremarketplace.Domain.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverId(Long receiverId);
    List<Message> findBySenderId(Long senderId);
}
