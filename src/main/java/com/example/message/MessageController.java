package com.example.message;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/api/messages")
    public List<MessageDto> getMessages(@RequestParam(required = false) String odosielatel) {
        return messageService.getMessagess(odosielatel);
    }

    @GetMapping("/api/messages/{messageId}")
    public MessageDto getMessage(@PathVariable Long messageId) {
        return messageService.getMessage(messageId);
    }

    @PostMapping("/api/messages")
    public Long createMessage(@RequestBody MessageDto messageDto) {
        System.out.println("1");
        return messageService.createMessage(messageDto);

    }

   @DeleteMapping("/api/messages/{messageId}")
    public void deleteMessage(@PathVariable int messageId) {
        messageService.deleteMessage(messageId);
    }

    @PutMapping("/api/messages/{messageId}")
    public void updateMessage(@PathVariable int messageId, @RequestBody MessageDto messageDto) {
        messageService.updateMessage(messageId, messageDto);
    }

}
