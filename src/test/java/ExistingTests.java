import de.cae.filter.Reduction1;
import de.cae.filter.Reduction2;
import de.cae.filter.Reduction3;
import de.cae.ipo.TextInput;
import de.cae.ipo.TextOutput;
import de.cae.ipo.Solver;
import de.cae.utils.IPOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExistingTests extends Tests {

    @Test
    public void existingTest1() {
        String inputFile = "src/test/resources/input/beispiel.txt";
        String outputFile = "src/test/resources/output/beispiel.txt";
        try {
            new Solver()
                    .input(new TextInput(inputFile))
                    .process()
                    .output(new TextOutput(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("Servicestationen in: FFM;HH", readFromOutputFile(outputFile));
    }

    @Test
    public void reduktion1() {
        String inputFile = "src/test/resources/input/reduktion1.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction1 reduction1 = new Reduction1();
            ArrayList<String> result = reduction1.algorithmus(input).get(0);
            List<String> expected = Arrays.asList("HH", "H", "K");
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertTrue(expected.containsAll(result));
            Assertions.assertTrue(result.containsAll(expected));
        } catch (IPOException e) {
            System.exit(1);
        }
    }

    @Test
    public void reduktion2() {
        String inputFile = "src/test/resources/input/reduktion2.txt";
        String outputFile = "src/test/resources/output/reduktion2.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction2 reduction2 = new Reduction2(generateAllStops(input));
            ArrayList<ArrayList<String>> result = reduction2.algorithmus(input);
            List<List<String>> expected = List.of(
                    Arrays.asList("S", "H", "K"),
                    Arrays.asList("FFM", "H", "K"),
                    Arrays.asList("M", "H", "B"),
                    Arrays.asList("C", "M", "H", "E")
            );
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertTrue(expected.containsAll(result));
            Assertions.assertTrue(result.containsAll(expected));
        } catch (IPOException e) {
            System.exit(1);
        }
    }

    @Test
    public void reduktion3() {
        String inputFile = "src/test/resources/input/reduktion3.txt";
        String outputFile = "src/test/resources/output/reduktion3.txt";
        try {
            TextInput textInput = new TextInput(inputFile);
            ArrayList<ArrayList<String>> input = textInput.readInFile();
            Reduction3 reduction3 = new Reduction3();
            ArrayList<ArrayList<String>> result = reduction3.algorithmus(input);
            List<List<String>> expected = List.of(
                    Arrays.asList("DA", "H"),
                    Arrays.asList("M", "N", "DA", "B"),
                    Arrays.asList("C", "M", "E")
            );
            Assertions.assertEquals(expected.size(), result.size());
            Assertions.assertTrue(expected.containsAll(result));
            Assertions.assertTrue(result.containsAll(expected));
        } catch (IPOException e) {
            System.exit(1);
        }
    }
}
