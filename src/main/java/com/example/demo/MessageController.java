package com.example.demo;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//xx
@RestController
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/api/messages")
    public List<MessageDto> getmessages(@RequestParam(required = false) String odosielatel) {
        return messageService.getMessagess(odosielatel);
    }

    @GetMapping("/api/messages/{messageId}")
    public MessageDto getMessage(@PathVariable Long messageId) {
        return messageService.getMessage(messageId);
    }

    @PostMapping("/api/messages")
    public Long createMessage(@RequestBody MessageDto messageDto) {
        return messageService.createMessage(messageDto);
    }

   /* @DeleteMapping("/api/messages/{messageId}")
    public void deleteBook(@PathVariable int bookId) {
        messageService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody MessageDto messageDto) {
        messageService.updateBook(bookId, messageDto);
    }
    */
}
