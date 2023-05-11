package de.cae.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasse zum Verarbeiten aller Programmargumente.
 */
public class CmdParser {
    private static final String INPUT = "-input";
    private static final String OUTPUT = "-output";
    private static final String LOG = "-log";
    private static final String LOG_LEVEL = "-loglvl";
    private static final String HELP = "-help";
    private static final Logger ROOT_LOGGER = Logger.getLogger("");
    private static final Logger LOGGER = Logger.getLogger(CmdParser.class.getName());

    private String input;
    private String output;

    /**
     * Erstellt eine neue Instanz und verarbeitet die übergebenen Argumente.
     *
     * @param args Programmargumente
     */
    public CmdParser(String[] args) {
        var logOption = LogOption.FALSE;
        for (var i = 0; i < args.length; i++) {
            switch (args[i]) {
                case INPUT -> this.input = args[++i];
                case OUTPUT -> this.output = args[++i];
                case LOG -> {
                    try {
                        logOption = LogOption.getOption(args[++i]);
                    } catch (IllegalArgumentException e) {
                        LOGGER.log(Level.WARNING, "Konnte " + args[i] + " keiner Log-Option zuordnen."
                                + "Log-Optionen sind true, false, file. Der default Wert ist false.");
                    }
                }
                case LOG_LEVEL -> {
                    Level logLevel = switch (args[++i]) {
                        case "info" -> Level.INFO;
                        case "warning" -> Level.WARNING;
                        default -> Level.ALL;
                    };
                    ROOT_LOGGER.setLevel(logLevel);
                }
                case HELP -> {
                    System.out.println("\033[0;32m" + "Benutzung: -input <inputFile> -output <outputFile> " +
                            "(-log [true, false, file]) (-loglvl [info, warning]) (-help)" + "\033[0m");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\033[0;31m" + "Invalid input argument: " + args[i] + "\033[0m");
                    System.out.println("\033[0;32m" +
                            "Benutzung: -input <inputFile> -output <outputFile> " +
                            "(-log [true, false, file]) (-loglvl [info, warning]) (-help)" + "\033[0m");
                    System.exit(0);
                }
            }
        }

        switch (logOption) {
            case FILE -> {
                try {
                    FileHandler FILE_HANDLER = new FileHandler("IHK_Abschlusspruefung.log", true);
                    ROOT_LOGGER.addHandler(FILE_HANDLER);
                } catch (IOException e) {
                    ROOT_LOGGER.log(Level.WARNING, "Konnte keinen FileHandler zum Logger hinzufügen. "
                            + "Logs werden in die Konsole geschrieben.");
                }
            }
            case FALSE -> {
                for (var handler : ROOT_LOGGER.getHandlers()) {
                    ROOT_LOGGER.removeHandler(handler);
                }
            }
        }
    }

    public String getInput() {
        return this.input;
    }

    public String getOutput() {
        return this.output;
    }

    /**
     * Enumeration für alle Logging Optionen, welche true, false oder file sind.
     */
    public enum LogOption {
        TRUE("true"),
        FALSE("false"),
        FILE("file");
        private final String value;

        LogOption(String value) {
            this.value = value;
        }

        public static LogOption getOption(String value) {
            for (var option : LogOption.values()) {
                if (option.value.equals(value)) {
                    return option;
                }
            }
            return FALSE;
        }
    }
}
