package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

/**
 * Filter für die Datenreduktionstechnik 2.
 */
public record Reduction2(ArrayList<String> allStops) implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

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
                ArrayList<Integer> list = new ArrayList<>();
                if (a != b) {
                    for (int c = 0; c < trainConnections.size(); c++) {
                        if (trainConnections.get(c).contains(allStops.get(a)) &&
                                trainConnections.get(c).contains(allStops.get(b))) {
                            list.add(c);
                        } else if (trainConnections.get(c).contains(allStops.get(a))) {
                            list.clear();
                            break;
//                            c = trainConnections.size();
                        }
                    }
                    if (list.size() > 2) {
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
