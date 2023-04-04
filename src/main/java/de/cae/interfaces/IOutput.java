package de.cae.interfaces;

/**
 * Ein Interface das die Ausgabe des EVA-Prinzips (IPO model: Input–Process–Output) entspricht.
 *
 * @param <T> das auszugebende Objekt.
 */
public interface IOutput<T> {

    /**
     * Methode zum Ausgeben eines Objekts unter einem bestimmten Pfad.
     *
     * @param output das in die Ausgabedatei geschrieben werden soll.
     * @return true, falls die Ausgabe erfolgreich war, sonst false.
     */
    public boolean writeToFile(T output);

}
