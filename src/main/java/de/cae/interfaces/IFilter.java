package de.cae.interfaces;

/**
 * Interface welches einen Filter der Pipes und Filter Architekturmuster definiert.
 *
 * @param <I> Eingabeobjekt in den Filter
 * @param <O> Ausgabeobjekt aus dem Filter
 */
public interface IFilter<I, O> {

    /**
     * Methode die den Algorithmus der Klasse entspricht.
     *
     * @param trainConnections Eingabedaten als Zugverbindungen
     * @return vom Algorithmus berechnetes Ergebnis
     */
    public O algorithmus(I trainConnections);
}
