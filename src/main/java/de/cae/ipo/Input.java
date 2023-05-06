package de.cae.ipo;

import de.cae.interfaces.IInput;
import de.cae.utils.IPOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public record Input(String pathToFile) implements IInput<String> {

    private static final Logger LOGGER = Logger.getLogger(Input.class.getName());

    @Override
    public String readInFile() throws IPOException {
        try {
            var file = new File(pathToFile);
            if (file.isFile() && file.canRead()) {
                StringBuilder input;
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    input = new StringBuilder();
                    LOGGER.log(Level.INFO, "Lese Datei ein: " + file.getAbsolutePath());
                    reader.lines().forEach(line -> input.append(line).append("\n"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                LOGGER.log(Level.INFO, "Einlesen war erfolgreich");
                return input.deleteCharAt(input.length() - 1).toString();
            } else {
                throw new IPOException("\033[0;31m" +
                        "Datei " + file.getAbsolutePath() + " konnte nicht eingelesen werden!" +
                        "\033[0m");
            }
        } catch (NullPointerException n) {
            throw new IPOException("\033[0;31m" + "Es wurde keine Eingabedatei angegeben!" + "\033[0m");
        }
    }
}
