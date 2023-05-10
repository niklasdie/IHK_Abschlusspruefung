package de.cae;

import de.cae.ipo.ProcessServiceStations;
import de.cae.ipo.TextInput;
import de.cae.ipo.TextOutput;
import de.cae.utils.CmdParser;
import de.cae.utils.IPOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main-Klasse welche über den Programmaufruf gestartet wird.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * main
     *
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        var cmdParser = new CmdParser(args);
        final long start = System.currentTimeMillis();
        try {
            new ProcessServiceStations()
                    .input(new TextInput(cmdParser.getInput()))
                    .process()
                    .output(new TextOutput(cmdParser.getOutput()))
                    .done();
            System.out.println("\033[0;32m" + "Der Programmablauf war erfolgreich." + "\033[0m");
        } catch (IPOException e) {
            System.out.println("\033[0;31m" + "ERROR: " + e.getMessage() + "\033[0m");
            System.exit(1);
        }
        final long end = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Programmlaufzeit: " + (end - start) + " Millisekunden.");
    }
}