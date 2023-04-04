package de.cae.models;

import de.cae.interfaces.IOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public record Output(String pathToFile) implements IOutput<String> {

    @Override
    public boolean writeToFile(String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
