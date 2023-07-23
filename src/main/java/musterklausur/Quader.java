package musterklausur;
/**
 * Quaderförmiges Gefäß mit quadratischer Grundfläche
 * @author Doro
 *
 */
public class Quader extends Gefaess {

	/**
	 * Länge einer Seite der Grundfläche in cm
	 */
	private double seitenlaenge;
	/**
	 * Höhe des Quaders in cm
	 */
	private double hoehe;

	/**
	 * erstellt ein Quader-Gefäß mit den angegebenen Werten
	 * @param preisInhalt
	 * @param seitenlaenge
	 * @param hoehe
	 */
	public Quader(double preisInhalt, double seitenlaenge, double hoehe) {
		super(preisInhalt);
		this.seitenlaenge = seitenlaenge;
		this.hoehe = hoehe;
	}

	// TODO: JavaDoc
	@Override
	double getVolumen() {
		return Math.pow(this.seitenlaenge, 2) * this.hoehe;
	}
}
