package de.cae.utils;

/**
 * Exception, die einen Fehler in dem IPO-Verfahren darstellt.
 */
public class IPOException extends Exception {

    /**
     * Konstruktor, welcher nur super aufruft.
     *
     * @param err Fehlermeldung
     */
    public IPOException(String err) {
        super(err);
    }
}
