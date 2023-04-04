package de.cae.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasse zum Verarbeiten aller Programmargumente.
 */
public class CmdParser {
    private static final String INPUT_STRING = "-input";
    private static final String OUTPUT_STRING = "-output";
    private static final String LOG_STRING = "-log";
    private static final String LOG_LEVEL_STRING = "-loglvl";
    private static final String HELP = "-help";
    private static final Logger ROOT_LOGGER = Logger.getLogger("");
    private static final Logger LOGGER = Logger.getLogger(CmdParser.class.getName());

    private String input;
    private String output;

    public CmdParser(String[] args) {
        var logOption = LogOption.TRUE;
        for (var i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                switch (args[i]) {
                    case INPUT_STRING -> this.input = args[++i];
                    case OUTPUT_STRING -> this.output = args[++i];
                    case LOG_STRING -> {
                        try {
                            logOption = LogOption.getOption(args[++i]);
                        } catch (IllegalArgumentException e) {
                            LOGGER.log(Level.WARNING, "Konnte " + args[i] + " keiner LOG_OPTION zuordnen."
                                    + "LOG_OPTIONen sind true, false, file. Der default Wert ist false.");
                        }
                    }
                    case LOG_LEVEL_STRING -> {
                        Level logLevel = switch (args[++i]) {
                            case "info" -> Level.INFO;
                            case "warning" -> Level.WARNING;
                            default -> Level.ALL;
                        };
                        ROOT_LOGGER.setLevel(logLevel);
                    }
                    case HELP -> {
                        LOGGER.log(Level.INFO,
                                "Benutzung: -input <inputFile> -output <outputFile> " +
                                        "(-log [true, false, file]) (-loglvl [info, warning, {}])");
                    }
                    default -> {
                        LOGGER.log(Level.WARNING, "Invalid input argument: " + args[++i]);
                        LOGGER.log(Level.INFO,
                                "Benutzung: -input <inputFile> -output <outputFile> " +
                                        "(-log [true, false, file]) (-loglvl [info, warning, {}])");
                    }
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
