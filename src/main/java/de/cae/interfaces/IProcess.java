package de.cae.interfaces;

import de.cae.utils.IPOException;

/**
 * Ein Interface das die Verarbeitung des EVA-Prinzips (IPO model: Input–Process–Output) entspricht.
 *
 * @param <I> das Eingabeobjekt
 * @param <O> das Eingabeobjekt
 */
public interface IProcess<I, O> {

    /**
     * Diese Methode wird am Ende des Chainings aufgerufen, um dieses zu beenden.
     */
    void done();

    /**
     * Methode, um mit einem IInput den Input einzulesen.
     *
     * @param IInput der Input
     * @return this Objekt für Chaining
     */
    IProcess<I, O> input(IInput<I> IInput) throws IPOException;

    /**
     * Methode um die Verarbeitung zu starten.
     *
     * @return this Objekt für Chaining
     */
    IProcess<I, O> process() throws IPOException;

    /**
     * Methode, um mit einem IOutput den Output zu schreiben.
     *
     * @param IOutput der Output
     * @return this Objekt für Chaining
     */
    IProcess<I, O> output(IOutput<O> IOutput) throws IPOException;

}
