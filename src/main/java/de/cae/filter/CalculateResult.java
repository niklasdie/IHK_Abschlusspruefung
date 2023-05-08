package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class CalculateResult implements IFilter<ArrayList<ArrayList<String>>, ArrayList<String>> {

    /**
     * Methode die den Algorithmus der Klasse entspricht.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    @Override
    public ArrayList<String> algorithmus(ArrayList<ArrayList<String>> trainConnections) {
        ArrayList<String> result = new ArrayList<>();
        while (!trainConnections.isEmpty()) {
        ArrayList<String> allStops = generateAllStops(trainConnections);
            int[] count = new int[allStops.size()];     // Array für Zählung der Stationen
            Arrays.fill(count, 0);
            for (ArrayList<String> connection : trainConnections) {
                for (String station : connection) {
                    count[allStops.indexOf(station)]++;     // Vorkommen jeder Station zählen
                }
            }
            int max = 0;
            int maxIndex = -1;
            for (int i = 0; i < count.length; i++) {       // maximale Anzahl suchen
                if (count[i] > max) {
                    max = count[i];
                    maxIndex = i;
                }
            }
            result.add(allStops.get(maxIndex));
            ArrayList<ArrayList<String>> trainConnectionsCopy = new ArrayList<>(trainConnections);
            for (ArrayList<String> connection : trainConnectionsCopy) {
                if (connection.contains(allStops.get(maxIndex))) {
                    trainConnections.remove(connection);
                }
            }
        }
        return result;
    }

    private static ArrayList<String> generateAllStops(ArrayList<ArrayList<String>> trainConnections) {
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
