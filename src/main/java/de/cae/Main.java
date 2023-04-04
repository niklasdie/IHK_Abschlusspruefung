package de.cae;

import de.cae.models.Input;
import de.cae.models.Output;
import de.cae.models.Solver;
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