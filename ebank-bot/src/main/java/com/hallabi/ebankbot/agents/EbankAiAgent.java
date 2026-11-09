package com.hallabi.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;

import org.springframework.stereotype.Service;


@Service
public class EbankAiAgent {
    private ChatClient chatClient;

    public EbankAiAgent(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        this.chatClient = chatClient

                .build();
    }


    public String Chat(String query){
        return chatClient.prompt(query).call().content();
    }
}
