package com.crispybrownies.typingGameSpring;

import com.crispybrownies.typingGameSpring.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    // Handles messages from /app/chat. (NOte the Spring adds the /app prefix for us).
    @MessageMapping("/chat")

    // Sends the return value of this method to /topic/messsages
    @SendTo("/topic/messages")
    public MessageDTO getMessages(MessageDTO dto) {
        return dto;
    }
}
