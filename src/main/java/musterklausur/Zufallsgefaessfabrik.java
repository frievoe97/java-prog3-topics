package musterklausur;

import java.util.Random;

/**
 * Die Klasse `Zufallsgefaessfabrik` ist eine konkrete Implementierung der abstrakten Klasse `Gefaessfabrik`
 * und dient dem Abstract Factory Pattern.
 * <p>
 * Diese Fabrik erstellt zufällig Gefäße der verschiedenen Typen (Zylinder, Quader oder Pyramide) mit den
 * angegebenen Maßen und dem Preis. Die Erstellung der Gefäße dauert eine bestimmte Zeit, um den asynchronen
 * Charakter der Fabrik zu demonstrieren.
 * <p>
 * Die Klasse enthält die statischen Konstanten `ANZAHL_SEKUNDEN`, `MILLISEKUNDEN_PRO_SEKUNDE` und
 * `ANZAHL_AN_GEFAESSTYPEN`, die für die Verzögerung und die Auswahl des Gefäßtyps verwendet werden.
 * <p>
 * Die Methode `erstelleGefaess` überschreibt die abstrakte Methode aus der Klasse `Gefaessfabrik` und
 * erzeugt ein zufälliges Gefäß vom Typ Zylinder, Quader oder Pyramide basierend auf den übergebenen Maßen
 * und dem Preis. Die Erstellung des Gefäßes dauert die in den Konstanten definierte Zeit, um den Effekt
 * der Verzögerung zu erzeugen.
 * <p>
 * Wenn die Erstellung des Gefäßes durch die Verzögerung unterbrochen wird (z. B. wenn der Thread unterbrochen
 * wird), wird `null` zurückgegeben.
 * <p>
 * Beachte: Die Klasse implementiert das Abstract Factory Pattern, indem sie die abstrakte Methode
 * `erstelleGefaess()` überschreibt, um konkrete Gefäße basierend auf den übergebenen Parametern zu erzeugen.
 *
 * @author frievoe97
 * @see Gefaessfabrik
 * @see Gefaessfabrik#erstelleGefaess(double, double, double)
 * @see Zylinder
 * @see Quader
 * @see Pyramide
 */
final class Zufallsgefaessfabrik extends Gefaessfabrik {

    /**
     * Die Zeitdauer, die benötigt wird, um ein Gefäß zu erzeugen.
     */
    public static final int ANZAHL_SEKUNDEN = 10;

    /**
     * Die Konstante für die Umrechnung von Sekunden in Millisekunden.
     */
    public static final int MILLISEKUNDEN_PRO_SEKUNDE = 1000;

    /**
     * Die Anzahl der verschiedenen Gefäßtypen (Zylinder, Quader, Pyramide).
     */
    public static final int ANZAHL_AN_GEFAESSTYPEN = 3;

    /**
     * Erstellt ein zufälliges Gefäß basierend auf den angegebenen Maßen und dem Preis.
     * Die Methode überschreibt die abstrakte Methode `erstelleGefaess()` aus der Klasse `Gefaessfabrik`.
     *
     * @param laenge Die Länge des neuen Gefäßes.
     * @param hoehe  Die Höhe des neuen Gefäßes.
     * @param preis  Der Preis pro cm³ des Inhalts des neuen Gefäßes.
     * @return Ein zufälliges Gefäß (Zylinder, Quader oder Pyramide) oder null, wenn die Erstellung
     * durch die Verzögerung unterbrochen wurde.
     */
    @Override
    Gefaess erstelleGefaess(double laenge, double hoehe, double preis) {

        try {
            // Verzögerung, um den asynchronen Charakter der Fabrik zu demonstrieren
            Thread.sleep(ANZAHL_SEKUNDEN * MILLISEKUNDEN_PRO_SEKUNDE);
            Random random = new Random();

            // Zufällig einen Gefäßtyp auswählen und das entsprechende Gefäß erzeugen
            switch (random.nextInt(ANZAHL_AN_GEFAESSTYPEN)) {
                case 0 -> {
                    return new Zylinder(preis, laenge, hoehe);
                }
                case 1 -> {
                    return new Quader(preis, laenge, hoehe);
                }
                case 2 -> {
                    return new Pyramide(preis, laenge, hoehe);
                }
            }
        } catch (InterruptedException ignored) {
            // Wenn die Erstellung des Gefäßes durch die Verzögerung unterbrochen wurde, wird null zurückgegeben.
        }

        return null;
    }
}
