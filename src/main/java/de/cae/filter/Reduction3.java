package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

public class Reduction3 implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

    /**
     * Methode die den Algorithmus der Klasse entspricht.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    @Override
    public ArrayList<ArrayList<String>> algorithmus(ArrayList<ArrayList<String>> trainConnections) {
        ArrayList<ArrayList<String>> trainConnectionsCopy = new ArrayList<>(trainConnections);
        for (ArrayList<String> connection : trainConnections) {
            for (ArrayList<String> connection2 : trainConnections) {
                if (!connection.equals(connection2)) {
                    boolean _switch = true;
                    for (String station : connection2) {
                        if (!connection.contains(station)) {
                            _switch = false;
                        }
                    }
                    if (_switch) {
                        trainConnectionsCopy.remove(connection);
                    }
                }
            }
        }
        return trainConnectionsCopy;
    }
}
