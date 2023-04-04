package de.cae.interfaces;

/**
 * Ein Interface das die Eingabe des EVA-Prinzips (IPO model: Input–Process–Output) entspricht.
 *
 * @param <T> das eingelesene Objekt.
 */
public interface IInput<T> {

    /**
     * Methode zum Einlesen eines Objekts unter einem bestimmten Pfad.
     *
     * @return das eingelesene Objekt in einem passenden Datentyp, welches bei der Implementation zu wählen ist.
     */
    public T readInFile();

}
