package de.cae;

import de.cae.ipo.Input;
import de.cae.ipo.Output;
import de.cae.ipo.Solver;
import de.cae.utils.CmdParser;

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

        new Solver()
                .input(new Input(cmdParser.getInput()))
                .process()
                .output(new Output(cmdParser.getOutput()))
                .done();

    }
}