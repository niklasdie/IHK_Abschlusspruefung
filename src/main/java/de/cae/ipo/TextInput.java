package de.cae.ipo;

import de.cae.interfaces.IInput;
import de.cae.utils.IPOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Eingabe des EVA-Modells, die eine Textdatei einliest und anhand der Daten Variablen initialisiert.
 */
public record TextInput(String pathToFile) implements IInput<ArrayList<ArrayList<String>>> {

    private static final Logger LOGGER = Logger.getLogger(TextInput.class.getName());

    @Override
    public ArrayList<ArrayList<String>> readInFile() throws IPOException {
        try {
            var file = new File(pathToFile);
            if (file.isFile() && file.canRead()) {
                ArrayList<ArrayList<String>> trainCons;
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    trainCons = new ArrayList<>();
                    LOGGER.log(Level.INFO, "Lese Datei ein: " + file.getAbsolutePath());
                    reader.lines().forEach(line -> {
                        if (!line.isEmpty() && line.charAt(0) != '#') {
                            ArrayList<String> input = new ArrayList<>(List.of(line.split(";")));
                            if (input.size() > 1) {
                                trainCons.add(input);
                            }
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                LOGGER.log(Level.INFO, "Einlesen war erfolgreich");
                return trainCons;
            } else {
                throw new IPOException("\033[0;31m" + "Datei " + file.getAbsolutePath() + " konnte nicht eingelesen werden!" + "\033[0m");
            }
        } catch (NullPointerException n) {
            throw new IPOException("\033[0;31m" + "Es wurde keine Eingabedatei angegeben!" + "\033[0m");
        }
    }
}
