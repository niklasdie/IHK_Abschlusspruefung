import de.cae.filter.Reduction1;
import de.cae.filter.Reduction2;
import de.cae.filter.Reduction3;
import de.cae.ipo.CalculateServiceStations;
import de.cae.ipo.TextInput;
import de.cae.ipo.TextOutput;
import de.cae.utils.IPOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OwnTests extends Tests {

    @Test
    public void minimalTest() {
        String inputFile = "src/test/resources/input/minimal.txt";
        String outputFile = "src/test/resources/output/minimal.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A", readFromOutputFile(outputFile));
    }

    @Test
    public void dreieck() {
        String inputFile = "src/test/resources/input/dreieck.txt";
        String outputFile = "src/test/resources/output/dreieck.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A;B", readFromOutputFile(outputFile));
    }

    @Test
    public void eineVerbindung() {
        String inputFile = "src/test/resources/input/eineVerbindung.txt";
        String outputFile = "src/test/resources/output/eineVerbindung.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A", readFromOutputFile(outputFile));
    }

    @Test
    public void eineVerbindung2() {
        String inputFile = "src/test/resources/input/eineVerbindung2.txt";
        String outputFile = "src/test/resources/output/eineVerbindung2.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A", readFromOutputFile(outputFile));
    }

    @Test
    public void viereck() {
        String inputFile = "src/test/resources/input/viereck.txt";
        String outputFile = "src/test/resources/output/viereck.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A;C", readFromOutputFile(outputFile));
    }

    @Test
    public void viereckEineVerbindung() {
        String inputFile = "src/test/resources/input/viereckEineVerbindung.txt";
        String outputFile = "src/test/resources/output/viereckEineVerbindung.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: A", readFromOutputFile(outputFile));
    }

    @Test
    public void grossesBeispiel() {
        String inputFile = "src/test/resources/input/grossesBeispiel.txt";
        String outputFile = "src/test/resources/output/grossesBeispiel.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: L", readFromOutputFile(outputFile));
    }

    @Test
    public void reduktion1() {
        String inputFile = "src/test/resources/input/reduktion1_eigen.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction1 reduction1 = new Reduction1();
            ArrayList<ArrayList<String>> result = reduction1.algorithmus(input);
            List<List<String>> expected = List.of(
                    Arrays.asList("A", "B"),
                    Arrays.asList("A", "C")
            );
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertEquals(expected, result);
        } catch (IPOException e) {
            System.exit(1);
        }
    }

    @Test
    public void reduktion2() {
        String inputFile = "src/test/resources/input/reduktion2_eigen.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction2 reduction2 = new Reduction2(generateAllStops(input));
            ArrayList<ArrayList<String>> result = reduction2.algorithmus(input);
            List<List<String>> expected = List.of(
                    Arrays.asList("X", "B"),
                    List.of("X"),
                    List.of("X"),
                    List.of("X")
            );
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertEquals(expected, result);
        } catch (IPOException e) {
            System.exit(1);
        }
    }

    @Test
    public void reduktion3() {
        String inputFile = "src/test/resources/input/reduktion3_eigen.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction3 reduction3 = new Reduction3();
            ArrayList<ArrayList<String>> result = reduction3.algorithmus(input);
            List<List<String>> expected = List.of(
                    Arrays.asList("A", "B"),
                    Arrays.asList("C", "D")
            );
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertEquals(expected, result);
        } catch (IPOException e) {
            System.exit(1);
        }
    }

    // Randfälle

    @Test
    public void eineStation() {
        String inputFile = "src/test/resources/input/randfaelle/eineStation.txt";
        String outputFile = "src/test/resources/output/randfaelle/eineStation.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in:", readFromOutputFile(outputFile));
    }

    @Test
    public void leereDatei() {
        String inputFile = "src/test/resources/input/randfaelle/leereDatei.txt";
        String outputFile = "src/test/resources/output/randfaelle/leereDatei.txt";
        try {
            new CalculateServiceStations()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in:", readFromOutputFile(outputFile));
    }
}
