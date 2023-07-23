package musterklausur;

/**
 * Die Klasse Quader stellt ein quaderförmiges Gefäß mit quadratischer Grundfläche dar.
 * Sie erbt von der abstrakten Klasse Gefaess und implementiert die abstrakte Methode getVolumen,
 * um das Volumen des Quaders zu berechnen.
 * Die Klasse enthält die Länge einer Seite der Grundfläche und die Höhe des Quaders.
 * <p>
 * Der Konstruktor ermöglicht die Erstellung eines Quader-Gefäßes mit den angegebenen Werten
 * für den Preis des Inhalts, die Seitenlänge und die Höhe.
 * <p>
 * Das Volumen des Quaders wird basierend auf den angegebenen Werten für die Seitenlänge und die Höhe berechnet.
 *
 * @author Doro
 */
public final class Quader extends Gefaess {

    /**
     * Die Länge einer Seite der Grundfläche in cm.
     */
    private final double seitenlaenge;

    /**
     * Die Höhe des Quaders in cm.
     */
    private final double hoehe;

    /**
     * Erstellt ein Quader-Gefäß mit den angegebenen Werten für den Preis des Inhalts,
     * die Seitenlänge und die Höhe.
     *
     * @param preisInhalt  Der Preis pro cm³ des Inhalts des Quaders.
     * @param seitenlaenge Die Länge einer Seite der Grundfläche des Quaders.
     * @param hoehe        Die Höhe des Quaders.
     */
    public Quader(double preisInhalt, double seitenlaenge, double hoehe) {
        super(preisInhalt);
        this.seitenlaenge = seitenlaenge;
        this.hoehe = hoehe;
    }

    /**
     * Berechnet das Volumen des Quaders basierend auf den angegebenen Werten für die Seitenlänge und die Höhe.
     *
     * @return Das Volumen des Quaders.
     */
    @Override
    double getVolumen() {
        return Math.pow(this.seitenlaenge, 2) * this.hoehe;
    }
}
