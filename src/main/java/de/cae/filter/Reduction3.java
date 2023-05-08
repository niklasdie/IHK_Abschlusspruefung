package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

/**
 * Filter für die Datenreduktionstechnik 3.
 */
public class Reduction3 implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

    /**
     * Methode um voll Überdeckungen zweier Züge zu vermeiden.
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
