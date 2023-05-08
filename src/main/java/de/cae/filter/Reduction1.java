package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

public class Reduction1 implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

    /**
     * Methode die den Algorithmus der Klasse entspricht.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    @Override
    public ArrayList<ArrayList<String>> algorithmus(ArrayList<ArrayList<String>> trainConnections) {

        for (ArrayList<String> connection : trainConnections) {
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> connectionCopy = new ArrayList<>(connection);
            // for-Schleife mit Indizes damit die Reihenfolge beim Entfernen gleich bleibt
            for (int i = 0; i < connectionCopy.size(); i++) {
                if (list.contains(connection.get(i))) {
                    connection.remove(i);
                } else {
                    list.add(connection.get(i));
                }
            }
        }
        return trainConnections;
    }
}
