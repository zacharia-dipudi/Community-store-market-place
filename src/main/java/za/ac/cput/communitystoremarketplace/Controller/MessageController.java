package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Message;
import za.ac.cput.communitystoremarketplace.Service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message) {
        return messageService.create(message);
    }

    @GetMapping("/read")
    public Message read(@RequestParam Long messageId) {
        return messageService.read(messageId);
    }

    @PutMapping("/update")
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long messageId) {
        return messageService.delete(messageId);
    }

    @GetMapping("/getAll")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/inbox")
    public List<Message> inbox(@RequestParam Long receiverId) {
        return messageService.getInbox(receiverId);
    }

    @GetMapping("/sent")
    public List<Message> sent(@RequestParam Long senderId) {
        return messageService.getSent(senderId);
    }
}
