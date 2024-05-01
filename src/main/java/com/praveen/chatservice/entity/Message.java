package com.praveen.chatservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;


    public Message(String content, ChatRoom chatRoom) {
        this.content = content;
        this.chatRoom = chatRoom;
    }

}
