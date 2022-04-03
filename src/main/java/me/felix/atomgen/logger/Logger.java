package me.felix.atomgen.logger;

import me.felix.atomgen.application.Namings;

public class Logger {

    public static void log(final String log) {
        System.out.println("[" + Namings.ANSI_RED + Namings.applicationName + Namings.ANSI_RESET + "] " + log);
    }

}
