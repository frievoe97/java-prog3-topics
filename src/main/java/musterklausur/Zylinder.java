package musterklausur;

/**
 * Zylindrisches Gefäß
 * @author Doro
 *
 */
public class Zylinder extends Gefaess {
	/**
	 * Durchmesser in cm
	 */
	private double durchmesser;
	/**
	 * Höhe des Zylinders in cm
	 */
	private double hoehe;

	/**
	 * erstellt einen Zylinder mit den angegebenen Werten
	 * @param preisInhalt
	 * @param durchmesser
	 * @param hoehe
	 */
	public Zylinder(double preisInhalt, double durchmesser, double hoehe) {
		super(preisInhalt);
		this.durchmesser = durchmesser;
		this.hoehe = hoehe;
	}

	// TODO: JavaDoc
	@Override
	double getVolumen() {
		return (Math.PI/4) * Math.pow(this.durchmesser, 2) * this.hoehe;
	}
}
