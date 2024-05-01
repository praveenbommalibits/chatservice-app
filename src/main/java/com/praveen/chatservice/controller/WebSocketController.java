package com.praveen.chatservice.controller;

import com.praveen.chatservice.entity.ChatRoom;
import com.praveen.chatservice.entity.Message;
import com.praveen.chatservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/chat/{roomId}/send")
    public void sendMessage(@DestinationVariable String roomId, Message message) {
        // Save the message to the database
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setId(Long.parseLong(roomId)); // Assuming roomId is the chat room ID
        message.setChatRoom(chatRoom);
        messageRepository.save(message);

        // Broadcast the message to all subscribers
        messagingTemplate.convertAndSend("/topic/chat/" + roomId, message);
    }

    @SubscribeMapping("/chat/{roomId}")
    public List<Message> loadMessages(@DestinationVariable String roomId) {
        // Retrieve and return messages from the database
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setId(Long.parseLong(roomId)); // Assuming roomId is the chat room ID
        return messageRepository.findByChatRoom(chatRoom);
    }

    @MessageMapping("/chat/{roomId}/delete/{messageId}")
    public void deleteMessage(@DestinationVariable String roomId, @DestinationVariable Long messageId) {
        // Retrieve the message from the database
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            // Check if the message belongs to the specified chat room
            if (message.getChatRoom().getId().equals(Long.parseLong(roomId))) {
                // Delete the message from the database
                messageRepository.delete(message);
                // Broadcast deletion confirmation to all subscribers
                messagingTemplate.convertAndSend("/topic/chat/" + roomId + "/delete", messageId);
            }
        }
    }
}

