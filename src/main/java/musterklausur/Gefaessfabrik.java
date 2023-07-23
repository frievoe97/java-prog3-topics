package musterklausur;

/**
 * Abstrakte Gefäßfabrik zum Erzeugen eines neuen Gefäßes.
 * Diese Klasse arbeitet nach dem Abstract Factory Pattern, bei dem eine abstrakte
 * Methode zum Erstellen eines neuen Gefäßes deklariert ist, die von den konkreten
 * Unterklassen implementiert werden muss, um das spezifische Gefäß zu erzeugen.
 * <p>
 * Die konkreten Unterklassen können verschiedene Arten von Gefäßen erstellen,
 * die von der abstrakten Klasse Gefaess abgeleitet sind.
 * <p>
 * Die Parameter der erstelleGefaess-Methode sind die erforderlichen Eigenschaften,
 * die zur Erzeugung des Gefäßes benötigt werden (z. B. Länge, Höhe und Preis).
 * <p>
 * Beachte: Da dies eine abstrakte Klasse ist, können keine Objekte dieser Klasse
 * direkt erzeugt werden. Stattdessen müssen die konkreten Unterklassen erstellt werden,
 * die die abstrakte Methode implementieren und tatsächlich Gefäße erzeugen können.
 *
 * @author frievoe97
 */
abstract class Gefaessfabrik {

    /**
     * Abstrakte Implementierung der Methode zum Erstellen eines neuen Gefäßes.
     *
     * @param laenge Die Länge des neuen Gefäßes.
     * @param hoehe Die Höhe des neuen Gefäßes.
     * @param preis Der Preis pro cm³ des Inhalts des neuen Gefäßes.
     * @return Produziertes Gefäß, das von der abstrakten Klasse Gefaess abgeleitet ist.
     */
    abstract Gefaess erstelleGefaess(double laenge, double hoehe, double preis);
}
