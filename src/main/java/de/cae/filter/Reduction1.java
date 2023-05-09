package de.cae.filter;

import de.cae.interfaces.IFilter;

import java.util.ArrayList;

/**
 * Filter für die Datenreduktionstechnik 1.
 */
public class Reduction1 implements IFilter<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> {

    /**
     * Methode um alle duplikaten Bahnhöfe einer Zugstrecke entfernt.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    @Override
    public ArrayList<ArrayList<String>> algorithmus(ArrayList<ArrayList<String>> trainConnections) {

        for (ArrayList<String> connection : trainConnections) {
            // Liste um alle Bahnhöfe hinzuzufügen und zu erkennen, ob es Redundanz gibt.
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> connectionCopy = new ArrayList<>(connection);     // Kopie
            // for-Schleife mit Indizes damit die Reihenfolge beim Entfernen gleich bleibt
            for (int i = 0; i < connectionCopy.size(); i++) {
                if (list.contains(connection.get(i))) {
                    // entfernen des redundanten Elements
                    connection.remove(i);
                    // durchlaufende Liste wurde geändert, Anpassung notwendig
                    connectionCopy = new ArrayList<>(connection);
                    i--;
                } else {
                    // Bahnhof noch nicht in Liste vorhanden -> hinzufügen
                    list.add(connection.get(i));
                }
            }
        }
        return trainConnections;
    }
}
