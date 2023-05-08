import de.cae.utils.IPOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Tests {

    public String readFromOutputFile(String filePath) {
        var file = new File(filePath);
        if (file.isFile() && file.canRead()) {
            StringBuilder input;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                input = new StringBuilder();
                reader.lines().forEach(line -> input.append(line).append("\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!input.isEmpty()) {
                return input.deleteCharAt(input.length() - 1).toString();
            }
        }
        return null;
    }

    void writeToFile(String pathToFile, ArrayList<ArrayList<String>> output) throws IPOException {
        try {
            File file = new File(pathToFile);
            try {
                StringBuilder outputString = new StringBuilder();
                for (ArrayList<String> a : output) {
                    for (String s : a) {
                        outputString.append(s).append(";");
                    }
                    outputString.append("\n");
                }

                FileWriter writer = new FileWriter(file);
                writer.write(outputString
                        .insert(0, "Servicestationen in: ")
                        .deleteCharAt(outputString.length() - 1)
                        .toString()
                );
                writer.close();
            } catch (IOException e) {
                throw new IPOException("\033[0;31m" +
                        "Datei " + file.getAbsolutePath() + " konnte nicht geschrieben werden!" +
                        "\033[0m");
            }
        } catch (NullPointerException n) {
            throw new IPOException("\033[0;31m" + "Es wurde keine Ausgabedatei angegeben!" + "\033[0m");
        }
    }

    public ArrayList<String> generateAllStops(ArrayList<ArrayList<String>> trainConnections) {
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> connection : trainConnections) {
            for (String station : connection) {
                if (!result.contains(station)) {
                    result.add(station);
                }
            }
        }
        return result;
    }
}
