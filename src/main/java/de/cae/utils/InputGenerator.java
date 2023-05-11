package de.cae.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class InputGenerator {

    public static void main(String[] args) {
        generateInput(101, 101, "input/generierterInput_101_101.txt");
    }

    public static void generateInput(int amountConnections, int amountStations, String file) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (int rows = 0; rows < amountConnections; rows++) {
            ArrayList<String> row = new ArrayList<>();
            for (int length = 0; length < (Math.random() / 2) * amountStations * 3 + 1; length++) {
                row.add(getToken(amountStations));
            }
            res.add(new ArrayList<>(row));
        }
        writeToFile(amountConnections, amountStations, res, file);
    }

    private static String getToken(int x) {
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < (x / 26) + 1; i++) {
            res.append((char) (random.nextInt(26) + 65));
        }
        return res.toString();
    }

    private static void writeToFile(int amountConnections, int amountStations, ArrayList<ArrayList<String>> output, String pathToFile) {
        File file = new File(pathToFile);
        try {
            StringBuilder outputString = new StringBuilder();
            for (ArrayList<String> l : output) {
                for (String s : l) {
                    outputString.append(s).append(";");
                }
                outputString.deleteCharAt(outputString.length() - 1).append("\n");
            }

            FileWriter writer = new FileWriter(file);
            writer.write(outputString
                    .insert(0, "# Generiertes Beispiel\n" +
                            "# mit " + amountConnections + " Zugverbindungen und " +
                            amountStations + " Zuegen\n")
                    .deleteCharAt(outputString.length() - 1)
                    .toString()
            );
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
