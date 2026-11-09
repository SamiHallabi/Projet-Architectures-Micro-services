package com.hallabi.ebankbot.controllers;

import com.hallabi.ebankbot.agents.EbankAiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbankChatbotController {
    private EbankAiAgent ebankAiAgent;

    public EbankChatbotController (EbankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }

    @GetMapping("/chat")
    public String Chat(@RequestParam(name = "query", defaultValue = "bonjour") String query){
        return ebankAiAgent.Chat(query);
    }
}
