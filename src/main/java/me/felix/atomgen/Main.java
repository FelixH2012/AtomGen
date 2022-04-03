package me.felix.atomgen;

import me.felix.atomgen.jda.JDAProcess;
import net.dv8tion.jda.api.JDA;

public class Main {

    private static JDAProcess jdaProcess;

    public static void main(String[] args) {
        jdaProcess = new JDAProcess();
        jdaProcess.initJDA(args);
    }

    public JDA getMainJDA() {
        return jdaProcess.mainJDA;
    }

}
