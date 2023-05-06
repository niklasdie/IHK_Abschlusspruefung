import java.io.*;

public class Tests {

    final static String inputFile = "src/test/resources/TestFile.txt";
    final static String outputFile = "src/test/resources/TestFile2.txt";

    public void writeToInputFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFromOutputFile() {
        var file = new File(outputFile);
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
}
