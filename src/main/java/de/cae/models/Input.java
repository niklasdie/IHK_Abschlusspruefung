package de.cae.models;

import de.cae.interfaces.IInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public record Input(String pathToFile) implements IInput<String> {

    @Override
    public String readInFile() {
        var file = new File(pathToFile);
        if (file.isFile() && file.canRead()) {
            StringBuilder input;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                input = new StringBuilder();
                reader.lines().forEach(line -> input.append(line).append("\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return input.deleteCharAt(input.length() - 1).toString();
        } else {
            return null;
        }
    }
}
