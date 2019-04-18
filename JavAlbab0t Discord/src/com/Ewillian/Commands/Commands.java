package com.Ewillian.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.ArrayList;

public class Commands extends ListenerAdapter {
	ArrayList<String> myCommands = new ArrayList<String>();
	
	public void onMessageReceived(MessageReceivedEvent  event) {
		
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();
        ArrayList<String> myCommands = new ArrayList<String>();
        
        System.out.println("Message received !");
        System.out.println(msg);
        
        if (event.isFromType(ChannelType.TEXT)) {
        	
        	if (msg.equals("<!ping"))
            {
                channel.sendMessage("pong!").queue();
            }else if (msg.equalsIgnoreCase("<!help"))
            {
        		String aswer = "Liste des commandes : \n ";
                myCommands.add("<!help - List commands list");
                myCommands.add("<!ping - Answer pong!");
                for (String com : myCommands) {
                	aswer += "`"+com+"` \n";
				}
                channel.sendMessage(aswer).queue();
            }else if (msg.equalsIgnoreCase("<!info"))
            {
            	
            	EmbedBuilder info = new EmbedBuilder();
            	info.setTitle("✨InesB0t✨");
            	info.setDescription("Bonjour, je suis l'interface numérique d'échange sociaux ou Ines. \n Pour plus d'information sur mes programmes tapez`<!help`.");
            	info.setColor(0x42ebf4);
            	info.setImage("https://github.com/Ewillian/JavAlbaBot-Discord/blob/master/Image/BotIcon.png?raw=true");
            	info.setFooter("Created by Ewillian", event.getGuild().getOwner().getUser().getAvatarUrl());
            	channel.sendMessage(info.build()).queue();
            }
        }else if (event.isFromType(ChannelType.PRIVATE)) {
        	if (msg.equalsIgnoreCase("Salut"))
            {
        		channel.sendMessage("Yo!").queue();
            }
        }
	}
}
