package de.cae;

import de.cae.ipo.Input;
import de.cae.ipo.Output;
import de.cae.ipo.Solver;
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

        try {
            new Solver()
                    .input(new Input(cmdParser.getInput()))
                    .process()
                    .output(new Output(cmdParser.getOutput()))
                    .done();
            System.out.println("\033[0;32m" + "Der Programmablauf war erfolgreich." + "\033[0m");
        } catch (IPOException e) {
            LOGGER.log(Level.SEVERE, "\033[0;31m" + e.getMessage() + "\033[0m");
            System.exit(1);
        }
    }
}