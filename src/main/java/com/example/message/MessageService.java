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

    private static MessageListDto mapToMessageDto(MessageEntity messageEntity) {
        MessageListDto messageListDto = new MessageListDto();
        messageListDto.setId(messageEntity.getId());
        messageListDto.setText(messageEntity.getText());
        messageListDto.setId_odosielatel(messageEntity.getId_odosielatel());
        messageListDto.setPrijemca(messageEntity.getPrijemca());

        return messageListDto;
    }

    @Transactional
    public List<MessageListDto> getMessagess(String Odosielatel) {
        List<MessageListDto> ret = new LinkedList<>();
        for (MessageEntity m1 : messageRepository.findAll()) {
            MessageListDto m2 = mapToMessageDto(m1);
            ret.add(m2);
        }
        return ret;
    }

    @Transactional
    public List<MessageListDto> getAllRoomMessagess(Long prijemca) {
        List<MessageListDto> ret = new LinkedList<>();
        for (MessageEntity m1 : messageRepository.findAll()) {
            MessageListDto m2 = mapToMessageDto(m1);
            ret.add(m2);
        }
        return ret;
    }
    //

    @Transactional
    public List<MessageListDto> getRoomMessages(Long prijemca) {

        List<MessageListDto> byRoomId = new LinkedList<>();

        if(prijemca!=null){
            for (MessageEntity b1 : messageRepository.findAllByPrijemca(prijemca)) {
                MessageListDto b2 = mapToMessageDto(b1);
                byRoomId.add(b2);
            }
        }
        return byRoomId;
    }

    /*
    @Transactional
    public MessageListDto getRoomMessages(Long prijemca) {

        Optional<MessageEntity> byRoomId = messageRepository.findByPrijemca(prijemca);

        if(byRoomId.isPresent()){
            return mapToMessageDto(byRoomId.get());
        }

        return null;
    }
/////////////////////////////////////////////////////
/*
        List<MessageDto> ret = new LinkedList<>();
        for (MessageEntity m1 : messageRepository.findByPrijimatel(prijemca)) {
            if(prijemca.equals(m1.getPrijemca()) ){
                MessageDto m2 = mapToMessageDto(m1);
                ret.add(m2);
            }
        }
        return ret;

        /*Optional<MessageEntity> byRoomId= messageRepository.findById(prijemca);

        List<MessageDto> byPrijemca = new LinkedList<>();

                messageRepository.findAllById(prijemca);

        if (byRoomId.isPresent()) {
            return byRoomId.get();

        return mapToMessageDto(byRoomId.get());
    }
    return null;*/




    @Transactional
    public MessageListDto getMessage(Long messageId) {
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
        messageEntity.setId_odosielatel(messageDto.getId_odosielatel());
        messageEntity.setPrijemca(messageDto.getPrijemca());
        //
        this.messageRepository.save(messageEntity);

        return messageEntity.getId();
    }

   @Transactional
    public void updateMessage(int messageId, MessageDto messageDto) {
        Optional<MessageEntity> byId = messageRepository.findById((long)messageId);
        if (byId.isPresent()) {
            byId.get().setId_odosielatel(messageDto.getId_odosielatel());
            byId.get().setText(messageDto.getText());
            byId.get().setPrijemca(messageDto.getPrijemca());
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
