package com.example.message;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    private static MessageDto mapToMessageDto(MessageEntity messageEntity) {
        MessageDto messageDto = new MessageDto();

        messageDto.setText(messageEntity.getText());
        messageDto.setOdosielatel(messageEntity.getOdosielatel());
        messageDto.setPrijimatel(messageEntity.getPrijimatel());
        return messageDto;
    }

    @Transactional
    public List<MessageDto> getMessagess(String Odosielatel) {
        List<MessageDto> ret = new LinkedList<>();
        for (MessageEntity m1 : messageRepository.findAll()) {
            MessageDto m2 = mapToMessageDto(m1);
            ret.add(m2);
        }
        return ret;
    }

    @Transactional
    public MessageDto getMessage(Long messageId) {
        Optional<MessageEntity> byId = messageRepository.findById(messageId);
        if (byId.isPresent()) {
            return mapToMessageDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createMessage(MessageDto messageDto) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setText(messageDto.getText());
        messageEntity.setOdosielatel(messageDto.getOdosielatel());
        messageEntity.setPrijimatel(messageDto.getPrijimatel());

        this.messageRepository.save(messageEntity);

        return messageEntity.getId();
    }

   @Transactional
    public void updateMessage(int messageId, MessageDto messageDto) {
        Optional<MessageEntity> byId = messageRepository.findById((long)messageId);
        if (byId.isPresent()) {
            byId.get().setOdosielatel(messageDto.getOdosielatel());
            byId.get().setPrijimatel(messageDto.getPrijimatel());
            byId.get().setText(messageDto.getText());
        }
    }


    @Transactional
    public void deleteMessage(int messageId) {
        Optional<MessageEntity> byId = messageRepository.findById((long)messageId);
        if (byId.isPresent()) {
            messageRepository.delete(byId.get());
        }
    }


}
