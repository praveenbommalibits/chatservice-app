package com.praveen.chatservice.service;

import com.praveen.chatservice.entity.ChatRoom;
import com.praveen.chatservice.repository.ChatRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomInitializer implements CommandLineRunner {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomInitializer(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (chatRoomRepository.count() == 0) {
            ChatRoom chatRoom = new ChatRoom("General");
            chatRoomRepository.save(chatRoom);
            System.out.println("Created a single chat room: " + chatRoom.getName());
        } else {
            System.out.println("Chat room already exists.");
        }
    }
}
