package musterklausur;

import java.text.NumberFormat;

/**
 * Die abstrakte Klasse Gefaess stellt ein Gefäß für den Verkauf dar.
 * Sie enthält den Preis pro cm³ des Inhalts des Gefäßes und Methoden
 * zum Abrufen des Namens, Vergleichen, Berechnen des Preises und
 * Berechnen des Volumens. Konkrete Unterklassen müssen die abstrakte
 * Methode getVolumen implementieren, um das Volumen des Gefäßes zu
 * berechnen. Die Klasse dient als Basisklasse für die konkreten
 * Gefäßtypen Zylinder, Quader und Pyramide.
 *
 * @author Doro
 */
public abstract class Gefaess {
    /**
     * Der Preis pro cm³ des Inhalts des Gefäßes.
     */
    private final double preisInhalt;

    /**
     * Erzeugt ein Gefäß mit dem angegebenen Inhaltspreis.
     *
     * @param preisInhalt Der Preis pro cm³ des Inhalts des Gefäßes.
     */
    public Gefaess(double preisInhalt) {
        this.preisInhalt = preisInhalt;
    }

    /**
     * Liefert den Namen des Gefäßes zurück.
     *
     * @return Der Name des Gefäßes.
     */
    public String getName() {
        return this.getClass().getSimpleName() + "(" + this.preisInhalt + ")";
    }

    /**
     * Vergleich von this mit other; Zwei Gefäße gelten als gleich,
     * wenn sie vom gleichen Subtyp sind und den gleichen Preis haben.
     *
     * @param other Das andere Objekt, mit dem verglichen wird.
     * @return true, wenn beide Gefäße als gleich gelten, sonst false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Gefaess g = (Gefaess) other;
        return Double.compare(g.preisInhalt, preisInhalt) == 0;
    }

    /**
     * Berechnet den Hashcode des Gefäßes, basierend auf dem Klassentyp und dem Preis des Inhalts.
     *
     * @return Der Hashcode des Gefäßes.
     */
    @Override
    public int hashCode() {
        return getClass().hashCode() * 59 + Double.hashCode(preisInhalt);
    }

    /**
     * Gibt eine textuelle Darstellung des Gefäßes zurück,
     * die den Klassennamen und den Preis des Inhalts enthält.
     *
     * @return Die textuelle Darstellung des Gefäßes.
     */
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return this.getClass().getSimpleName() + " zum Preis von "
                + nf.format(this.getPreis());
    }

    /**
     * Berechnet den Preis des Inhalts des Gefäßes basierend auf dem Volumen
     * und dem Preis pro cm³ des Inhalts.
     * Diese Methode arbeitet nach dem Template Method Pattern, da sie die abstrakte Methode
     * getVolumen aufruft, die von den konkreten Unterklassen implementiert werden muss,
     * um das Volumen zu berechnen.
     *
     * @return Der Preis des Inhalts des Gefäßes.
     */
    public double getPreis() {
        return this.getVolumen() * this.preisInhalt;
    }

    /**
     * Diese abstrakte Methode muss von den konkreten Unterklassen implementiert werden,
     * um das Volumen des Gefäßes zu berechnen.
     *
     * @return Das Volumen des Gefäßes.
     */
    abstract double getVolumen();
}
