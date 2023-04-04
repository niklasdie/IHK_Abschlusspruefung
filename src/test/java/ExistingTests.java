import de.cae.models.Input;
import de.cae.models.Output;
import de.cae.models.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExistingTests extends Tests {

    @Test
    public void existingTest1() {
        writeToInputFile("Test123Test\n123Test123");

        new Solver()
                .input(new Input(inputFile))
                .process()
                .output(new Output(outputFile))
                .done();

        Assertions.assertEquals("TestABCTest\nABCTestABC", readFromOutputFile());
    }
}