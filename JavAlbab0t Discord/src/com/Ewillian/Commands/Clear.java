package com.Ewillian.Commands;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		// https://www.youtube.com/watch?v=NevtahMI0Ks
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(event.getMember().getRoles().contains("Venerable Buisson")) {
			EmbedBuilder access = new EmbedBuilder();
			access.setColor(0x22ff2a);
			access.setTitle("✔ Accès authorisé !");
			access.setDescription("Vous avez les droits nécéssaires pour utiliser cette commande.");
			event.getChannel().sendMessage(access.build()).queue();		
				
			if(args[0].equalsIgnoreCase("<!clear")) {
				if(args.length < 2) {
					EmbedBuilder error = new EmbedBuilder();
					error.setColor(0xff3923);
					error.setTitle("⛔Érreur⛔ Utilisation de la commande incomplète.");
					error.setDescription("ℹ Utilisation correcte est: `<!clear {MESSAGE NUMBER}`.");
					event.getChannel().sendMessage(error.build()).queue();	
				}else {
					try {
						
						MessageHistory history = new MessageHistory(event.getChannel());
						List<Message> messages;
						int numb = Integer.parseInt(args[1]);
						messages = history.retrievePast(numb).complete();
						event.getChannel().deleteMessages(messages).queue();
						
	                    EmbedBuilder error = new EmbedBuilder();
	                    error.setColor(0x22ff2a);
	                    error.setTitle("✔ Suppréssion éffectué.");
	                    error.setDescription("✔ Les "+args[1]+" messages ont bien été supprimés.");
	                    event.getChannel().sendMessage(error.build()).queue();
					} catch (Exception e) {
						if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
	                        EmbedBuilder error = new EmbedBuilder();
	                        error.setColor(0xff3923);
	                        error.setTitle("⛔Érreur⛔ Trop de messages sélectionnés.");
	                        error.setDescription("ℹ Vous ne pouvez que sélectionner entre 1 et 100 messages.");
	                        event.getChannel().sendMessage(error.build()).queue();
						}else {
							EmbedBuilder error = new EmbedBuilder();
	                        error.setColor(0xff3923);
	                        error.setTitle("⛔Érreur⛔ Les messages sélectionnés sont trop vieux.");
	                        error.setDescription("ℹ Les messages vieux de 2 semaines ne peuvent être sélectionnés.");
	                        event.getChannel().sendMessage(error.build()).queue();
						}
					}
				}		
		}else {
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(0xff3923);
			error.setTitle("⛔Érreur⛔ Utilisation de la commande interdite!!");
			error.setDescription("ℹ Vous n'avez pas les droits nécéssaires pour utiliser cette commande.");
			event.getChannel().sendMessage(error.build()).queue();
			}
		}
	}
}
