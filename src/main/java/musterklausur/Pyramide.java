package musterklausur;

/**
 * Die Klasse Pyramide stellt ein pyramidenförmiges Gefäß mit quadratischer Grundfläche dar.
 * Sie erbt von der abstrakten Klasse Gefaess und implementiert die abstrakte Methode getVolumen,
 * um das Volumen der Pyramide zu berechnen.
 * Die Klasse enthält die Länge einer Seite der Grundfläche und die Höhe der Pyramide.
 * <p>
 * Der Konstruktor ermöglicht die Erstellung eines Pyramiden-Gefäßes mit den angegebenen Werten
 * für den Preis des Inhalts, die Seitenlänge und die Höhe.
 * <p>
 * Das Volumen der Pyramide wird basierend auf den angegebenen Werten für die Seitenlänge und die Höhe berechnet.
 * <p>
 *
 * @author Doro
 */
public final class Pyramide extends Gefaess {

    /**
     * Die Länge einer Seite der Grundfläche in cm.
     */
    private final double seitenlaenge;

    /**
     * Die Höhe der Pyramide in cm.
     */
    private final double hoehe;

    /**
     * Erstellt ein Pyramiden-Gefäß mit den angegebenen Werten für den Preis des Inhalts,
     * die Seitenlänge und die Höhe.
     *
     * @param preisInhalt  Der Preis pro cm³ des Inhalts der Pyramide.
     * @param seitenlaenge Die Länge einer Seite der Grundfläche der Pyramide.
     * @param hoehe        Die Höhe der Pyramide.
     */
    public Pyramide(double preisInhalt, double seitenlaenge, double hoehe) {
        super(preisInhalt);
        this.seitenlaenge = seitenlaenge;
        this.hoehe = hoehe;
    }

    /**
     * Berechnet das Volumen der Pyramide basierend auf den angegebenen Werten für die Seitenlänge und die Höhe.
     *
     * @return Das Volumen der Pyramide.
     */
    @Override
    double getVolumen() {
        return (1. / 3) * Math.pow(this.seitenlaenge, 2) * this.hoehe;
    }
}
