import de.cae.ipo.Input;
import de.cae.ipo.Output;
import de.cae.ipo.Solver;
import de.cae.utils.IPOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExistingTests extends Tests {

    @Test
    public void existingTest1() {
        writeToInputFile("Test123Test\n123Test123");

        try {
            new Solver()
                    .input(new Input(inputFile))
                    .process()
                    .output(new Output(outputFile))
                    .done();
        } catch (IPOException e) {
            System.exit(1);
        }

        Assertions.assertEquals("TestABCTest\nABCTestABC", readFromOutputFile());
    }
}
