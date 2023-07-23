package musterklausur;

/**
 * Abstrakte Gefässfabrik zum Erzeugen eines neuen Gefäßes.
 */
abstract class Gefaessfabrik {

    /**
     * Abstrakte Implementierung der Methode zum Erstellen eines neuen Gefäßes.
     *
     * @param laenge
     * @param hoehe
     * @param preis
     * @return Produziertes Gefäß
     */
    abstract Gefaess erstelleGefaess(double laenge, double hoehe, double preis);
}
