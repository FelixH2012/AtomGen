package me.felix.atomgen.jda;

import lombok.experimental.UtilityClass;
import net.dv8tion.jda.api.entities.User;

import java.io.File;
import java.io.RandomAccessFile;

@UtilityClass
public class Util {

    public void sendMessage(User user, String content) {
        if (content != null) {
            user.openPrivateChannel().flatMap(channel -> channel.sendMessage(content)).queue();
        }
    }

    public String getRandomLineFromTheFile(String filePathWithFileName) throws Exception {

        File file = new File(filePathWithFileName);
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        f.readLine();
        String randomLine = f.readLine();
        f.close();
        return randomLine;
    }

}
