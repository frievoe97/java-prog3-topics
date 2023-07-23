package musterklausur;

import java.util.Random;

// TODO: JavaDoc
class Zufallsgefaessfabrik extends Gefaessfabrik {

    public static final int ANZAHL_SEKUNDEN = 10;
    public static final int MILLISEKUNDEN_PRO_SEKUNDE = 1000;
    public static final int ANZAHL_AN_GEFAESTYPEN = 3;

    // TODO: JavaDoc
    @Override
    Gefaess erstelleGefaess(double laenge, double hoehe, double preis) {

        try {
            Thread.sleep(ANZAHL_SEKUNDEN * MILLISEKUNDEN_PRO_SEKUNDE);
            Random random = new Random();

            switch (random.nextInt(ANZAHL_AN_GEFAESTYPEN)) {
                case 0:
                    return new Zylinder(preis, laenge, hoehe);
                case 1:
                    return new Quader(preis, laenge, hoehe);
                case 2:
                    return new Pyramide(preis, laenge, hoehe);
            }
        } catch (InterruptedException ignored) {

        }

        return null;
    }
}