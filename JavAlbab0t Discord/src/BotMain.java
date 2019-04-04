import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class BotMain {

	public static JDA jda;
	
	
	public static void main(String[] args) throws LoginException, InterruptedException {

		JDA jda = new JDABuilder(AccountType.BOT)
				.setToken("").build();
		
	}

}
