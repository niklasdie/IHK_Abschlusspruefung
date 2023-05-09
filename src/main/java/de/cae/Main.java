package de.cae;

import de.cae.ipo.CalculateServiceStations;
import de.cae.ipo.TextInput;
import de.cae.ipo.TextOutput;
import de.cae.utils.CmdParser;
import de.cae.utils.IPOException;

/**
 * Main-Klasse welche über den Programmaufruf gestartet wird.
 */
public class Main {

    /**
     * main
     *
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        var cmdParser = new CmdParser(args);

        try {
            new CalculateServiceStations()
                    .input(new TextInput(cmdParser.getInput()))
                    .process()
                    .output(new TextOutput(cmdParser.getOutput()))
                    .done();
            System.out.println("\033[0;32m" + "Der Programmablauf war erfolgreich." + "\033[0m");
        } catch (IPOException e) {
            System.out.println("\033[0;31m" + "ERROR: " + e.getMessage() + "\033[0m");
            System.exit(1);
        }
    }
}