package de.cae.ipo;

import de.cae.filter.CalculateResult;
import de.cae.filter.Reduction1;
import de.cae.filter.Reduction2;
import de.cae.filter.Reduction3;
import de.cae.interfaces.IInput;
import de.cae.interfaces.IOutput;
import de.cae.interfaces.IProcess;
import de.cae.utils.IPOException;

import java.util.ArrayList;

/**
 * Verarbeitung des EVA-Modells, welche die minimale Anzahl von Servicestationen und deren Standort
 * anhand einer Eingabe berechnet und das Ergebnis ausgibt.
 */
public class ProcessServiceStations implements IProcess<ArrayList<ArrayList<String>>, ArrayList<String>> {

    private ArrayList<ArrayList<String>> trainConnections;
    private ArrayList<String> allStops;
    private ArrayList<String> result;

    @Override
    public void done() {
    }

    @Override
    public IProcess<ArrayList<ArrayList<String>>, ArrayList<String>>
    input(IInput<ArrayList<ArrayList<String>>> IInput) throws IPOException {
        this.trainConnections = IInput.readInFile();
        return this;
    }

    @Override
    public IProcess<ArrayList<ArrayList<String>>, ArrayList<String>>
    process() throws IPOException {
        if (trainConnections.isEmpty()) {
            throw new IPOException("Keine Zugverbindungen vorhanden zum verarbeiten.");
        }
        allStops = generateAllStops(trainConnections);
        Reduction1 reduction1 = new Reduction1();
        reduction1.algorithmus(trainConnections);
        Reduction2 reduction2 = new Reduction2(allStops);
        reduction2.algorithmus(trainConnections);
        Reduction3 reduction3 = new Reduction3();
        reduction3.algorithmus(trainConnections);
        CalculateResult calculateResult = new CalculateResult();
        result = calculateResult.algorithmus(trainConnections);
        return this;
    }

    @Override
    public IProcess<ArrayList<ArrayList<String>>, ArrayList<String>>
    output(IOutput<ArrayList<String>> IOutput) throws IPOException {
        IOutput.writeToFile(result);
        return this;
    }

    private ArrayList<String> generateAllStops(ArrayList<ArrayList<String>> trainConnections) {
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
