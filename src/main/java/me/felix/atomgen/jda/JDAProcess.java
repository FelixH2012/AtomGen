package me.felix.atomgen.jda;

import me.felix.atomgen.application.Namings;
import me.felix.atomgen.jda.listener.KeyTypingListener;
import me.felix.atomgen.jda.listener.ListenerHandler;
import me.felix.atomgen.logger.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class JDAProcess {

    public JDA mainJDA;

    public void initJDA(String[] args) {
        try {
            mainJDA = JDABuilder.createLight(JdaData.discordClientID, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES).addEventListeners(new KeyTypingListener()).setActivity(Activity.playing("The new alt gen, all alts are geklaut von auxy")).build();
            Logger.log(String.valueOf(mainJDA.getStatus()));
        } catch (LoginException e) {
            if (e.getMessage().contains("invalid!")) {
                Logger.log("Unable to login, the provided key is invalid. Key (" + JdaData.discordClientID + ")");
            } else {
                Logger.log(e.getMessage());
            }
        }
        Logger.log(Namings.applicationName + " Initialized successfully!");
    }
}
