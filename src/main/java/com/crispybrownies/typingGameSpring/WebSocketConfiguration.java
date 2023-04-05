package com.crispybrownies.typingGameSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Set prefix for the endpoint that the client listens
        registry.enableSimpleBroker("/gameTx");
        // Set prefix for the endpoint that the client will send messages to
        registry.setApplicationDestinationPrefixes("/gameRx");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Registers the endpoint where the connection will take place
        registry.addEndpoint("/gameWS")
                // Allow the origin to send messages
                .setAllowedOrigins("https://localhost:3000")
                // Enable SockJS fallback option
                .withSockJS();
    }
}
