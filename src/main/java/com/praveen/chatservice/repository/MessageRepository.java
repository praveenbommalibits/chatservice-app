package com.praveen.chatservice.repository;

import com.praveen.chatservice.entity.ChatRoom;
import com.praveen.chatservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatRoom(ChatRoom chatRoom);
}

