package com.Ewillian.BotMain;
import javax.security.auth.login.LoginException;

import com.Ewillian.Commands.Clear;
import com.Ewillian.Commands.Commands;
import com.Ewillian.Events.GuildMemberJoin;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class MainBot {

	public static JDA jda;
	
	public static void main(String[] args) throws LoginException, InterruptedException {
		System.out.println("Alive");
		JDA jda = new JDABuilder(AccountType.BOT)
				.setToken("").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.playing("Warframe"));
		
		jda.addEventListener(new Commands());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new Clear());
	}

}