
package com.praveen.chatservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;



@Configuration
public class WebSocketConfig {


    @Bean
    public MessageChannel myMessageChannel() {
        return new DirectChannel(); // Create a DirectChannel
    }

    @Bean
    public SimpMessagingTemplate messagingTemplate(MessageChannel myMessageChannel) {
        return new SimpMessagingTemplate(myMessageChannel);
    }
}


