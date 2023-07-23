package musterklausur;

/**
 * Die Klasse Zylinder stellt ein zylindrisches Gefäß dar.
 * Sie erbt von der abstrakten Klasse Gefaess.
 *
 * @author Doro
 */
public final class Zylinder extends Gefaess {
    /**
     * Durchmesser des Zylinders in cm.
     */
    private final double durchmesser;

    /**
     * Höhe des Zylinders in cm.
     */
    private final double hoehe;

    /**
     * Erzeugt einen Zylinder mit den angegebenen Werten.
     *
     * @param preisInhalt Der Preis pro cm³ des Inhalts des Zylinders.
     * @param durchmesser Der Durchmesser des Zylinders in cm.
     * @param hoehe       Die Höhe des Zylinders in cm.
     */
    public Zylinder(double preisInhalt, double durchmesser, double hoehe) {
        super(preisInhalt);
        this.durchmesser = durchmesser;
        this.hoehe = hoehe;
    }

    /**
     * Berechnet das Volumen des Zylinders basierend auf den angegebenen Werten
     * für den Durchmesser und die Höhe.
     *
     * @return Das Volumen des Zylinders.
     */
    @Override
    double getVolumen() {
        return (Math.PI / 4) * Math.pow(this.durchmesser, 2) * this.hoehe;
    }
}
