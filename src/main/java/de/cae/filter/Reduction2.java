package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

/**
 * Filter für die Datenreduktionstechnik 2.
 */
public record Reduction2(
        ArrayList<String> allStops) implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

    /**
     * Methode um alle Bahnhöfe zu entfernen, die Teilmengen von anderen Zügen sind.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    @Override
    public ArrayList<ArrayList<String>> algorithmus(ArrayList<ArrayList<String>> trainConnections) {
        for (int a = 0; a < allStops.size(); a++) {
            for (int b = 0; b < allStops.size(); b++) {
                // List für alle Zugverbindungen die Bahnhof A und B anlaufen.
                ArrayList<Integer> list = new ArrayList<>();
                if (a != b) {
                    for (int c = 0; c < trainConnections.size(); c++) {
                        // Wenn Zug in Bahnhof A und B hält
                        if (trainConnections.get(c).contains(allStops.get(a)) &&
                                trainConnections.get(c).contains(allStops.get(b))) {
                            list.add(c);            // wird Liste hinzugefügt
                        } else
                            // Wenn Zug nur in Bahnhof A hält
                            if (trainConnections.get(c).contains(allStops.get(a))) {
                                list.clear();       // Liste wird geleert
                                break;              // und Durchlauf wird abgebrochen
                            }
                    }
                    if (list.size() > 1) {
                        // In alle Zugverbindungen die Bahnhof A und B anlaufen, kann A gelöscht werden.
                        for (Integer integer : list) {
                            trainConnections.get(integer).remove(allStops.get(a));
                        }
                    }
                }
            }
        }
        return trainConnections;
    }
}
