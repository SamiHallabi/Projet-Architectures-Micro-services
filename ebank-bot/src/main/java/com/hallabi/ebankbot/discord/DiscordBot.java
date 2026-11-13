package com.hallabi.ebankbot.discord;


import com.hallabi.ebankbot.agents.EbankAiAgent;
import com.zgamelogic.discord.annotations.DiscordController;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import com.zgamelogic.discord.annotations.DiscordMapping;


@DiscordController
public class DiscordBot {
    private EbankAiAgent ebankAiAgent;

    public DiscordBot(EbankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event) {
        System.out.println(event);
        if (event.getAuthor().isBot()) {
            return;
        }
        String query = event.getMessage().getContentRaw();
        String response = ebankAiAgent.Chat(query, event.getChannel().getId());
        event.getChannel().sendMessage(response).queue();
    }
}
