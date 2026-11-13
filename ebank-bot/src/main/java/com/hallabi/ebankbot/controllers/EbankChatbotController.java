package com.hallabi.ebankbot.controllers;

import com.hallabi.ebankbot.agents.EbankAiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class EbankChatbotController {
    private EbankAiAgent ebankAiAgent;

    public EbankChatbotController (EbankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }

    @GetMapping(value = "/chat" , produces = MediaType.TEXT_PLAIN_VALUE)
    public String Chat(@RequestParam(name = "query", defaultValue = "bonjour") String query, @RequestParam String conversationId){
        return ebankAiAgent.Chat(query, conversationId);
    }
}
