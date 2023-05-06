package de.cae.ipo;

import de.cae.interfaces.IOutput;
import de.cae.utils.IPOException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public record Output(String pathToFile) implements IOutput<String> {

    private static final Logger LOGGER = Logger.getLogger(Output.class.getName());

    @Override
    public boolean writeToFile(String output) throws IPOException {
        try {
            File file = new File(pathToFile);
            try {
                FileWriter writer = new FileWriter(file);
                LOGGER.log(Level.INFO, "Schreibe Datei: " + file.getAbsolutePath());
                writer.write(output);
                writer.close();
                LOGGER.log(Level.INFO, "Schreiben war erfolgreich");
                return true;
            } catch (IOException e) {
                throw new IPOException("\033[0;31m" +
                        "Datei " + file.getAbsolutePath() + " konnte nicht geschrieben werden!" +
                        "\033[0m");
            }
        } catch (NullPointerException n) {
            throw new IPOException("\033[0;31m" + "Es wurde keine Ausgabedatei angegeben!" + "\033[0m");
        }
    }
}
