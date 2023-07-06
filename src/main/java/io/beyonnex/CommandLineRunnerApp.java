package io.beyonnex;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.beyonnex.api.AnagramApi;
import io.beyonnex.config.AppInjector;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * A command-line runner application that uses the AnagramApi to check if two strings are anagrams.
 *
 * @author Guilherme D'Amoreira
 */
public class CommandLineRunnerApp {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%n");
        log = Logger.getLogger(CommandLineRunnerApp.class.getName());
    }

    /**
     * The main entry point of the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            log.warning("Usage: java -jar beyonnex.jar <string1> <string2>");
            log.warning("Check if two strings are anagrams.");
            log.warning("Example: java -jar beyonnex.jar \"angel\" \"glean\"");
            throw new InvalidParameterException("Invalid parameters provided. Please provide 2 positional parameters. E.g.: java -jar beyonnex.jar \"angel\" \"glean\"");
        }
        Injector injector = Guice.createInjector(new AppInjector());

        AnagramApi api = injector.getInstance(AnagramApi.class);

        api.run(args[0], args[1]);
    }

}
