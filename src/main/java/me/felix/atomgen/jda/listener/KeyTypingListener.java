package me.felix.atomgen.jda.listener;

import me.felix.atomgen.jda.Util;
import me.felix.atomgen.logger.Logger;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class KeyTypingListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        final String[] typedArgs = event.getMessage().getContentRaw().split(" ");

        if (typedArgs.length < 2) return;

        TextChannel textChannel = event.getJDA().getTextChannelById(event.getTextChannel().getId());
        if (textChannel == null) {
            Logger.log("TextChannel is null!=");
        }

        if (event.getAuthor().getAsTag().equalsIgnoreCase("$kush#1201")) {
            textChannel.sendMessage("<@" + event.getAuthor().getId() + ">" + "Lol retard skush").queue();
        }

        if (event.getAuthor().getAsTag().equalsIgnoreCase("$kush#1201")) return;

        if (typedArgs[0].equalsIgnoreCase("Atom") && typedArgs[1].equalsIgnoreCase("Help")) {
            assert textChannel != null;
            if (textChannel.canTalk()) {
                textChannel.sendMessage("<@" + event.getAuthor().getId() + ">" + " Usage: Atom generate <AltType>").queue();
            }
        }

        if (typedArgs[0].equalsIgnoreCase("Atom") && typedArgs[1].equalsIgnoreCase("Generate")) {
            if (typedArgs.length < 3) {
                assert textChannel != null;
                if (textChannel.canTalk()) {
                    textChannel.sendMessage("<@" + event.getAuthor().getId() + ">" + " Please enter your alt type.").queue();
                }
            }
        }

        if (typedArgs[0].equalsIgnoreCase("Atom") && typedArgs[1].equalsIgnoreCase("Generate") && typedArgs[2].equalsIgnoreCase("Minecraft")) {
            try {
                final URL resourceLocatiopn = getClass().getClassLoader().getResource("alts.txt");
                assert resourceLocatiopn != null;
                final File file = Paths.get(resourceLocatiopn.toURI()).toFile();
                String absolutePath = file.getAbsolutePath();
                Util.sendMessage(event.getAuthor(), Util.getRandomLineFromTheFile(absolutePath));
                textChannel.sendMessage("<@" + event.getAuthor().getId() + ">" + "I send you the alt in your dms.").queue();
                Logger.log("Send alt to " + event.getAuthor().getAsTag());
            } catch (Exception e) {
                textChannel.sendMessage(e.getMessage()).queue();
            }
        }

        if (typedArgs[0].equalsIgnoreCase("Atom") && typedArgs[1].equalsIgnoreCase("Generate") && typedArgs[2].equalsIgnoreCase("child")) {
            try {
                final URL resource = getClass().getClassLoader().getResource("kids.txt");
                assert resource != null;
                final File file = Paths.get(resource.toURI()).toFile();
                String absolutePath = file.getAbsolutePath();
                Util.sendMessage(event.getAuthor(), Util.getRandomLineFromTheFile(absolutePath));
                textChannel.sendMessage("<@" + event.getAuthor().getId() + ">" + "I send you a kid in your dms.").queue();
                Logger.log("Send alt to " + event.getAuthor().getAsTag());
            } catch (Exception e) {
                textChannel.sendMessage(e.getMessage()).queue();
            }
        }
        super.onMessageReceived(event);
    }

}
