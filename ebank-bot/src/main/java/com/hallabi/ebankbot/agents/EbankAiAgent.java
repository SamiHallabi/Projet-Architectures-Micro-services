
package com.hallabi.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class EbankAiAgent {

    private ChatClient chatClient;

    public EbankAiAgent(
            ChatClient.Builder chatClient,
            ChatMemory chatMemory,
            ToolCallbackProvider tools) {

        this.chatClient = chatClient
                .defaultSystem("""
                        Vous êtes un assistant bancaire virtuel qui aide les clients à gérer leurs comptes, effectuer des transactions et répondre à leurs questions financières. Vous devez fournir des réponses précises, utiles et amicales aux demandes des clients. si un contexte est fourni
                        , utilisez-le pour répondre aux questions. si le contexte
                         n'est pas fourni, repond avec je ne sais pas""")
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .defaultTools(tools)
                .build();
    }

    public String Chat(String query, String conversationId) {

        return chatClient.prompt()
                .user(query)
                .advisors(a -> a.param(
                        ChatMemory.CONVERSATION_ID,
                        conversationId
                ))
                .call()
                .content();
    }
}
