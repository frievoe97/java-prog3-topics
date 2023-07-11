package enums;

/**
 * Hauptklasse, die die Verwendung von Enums demonstriert.
 */
public class EnumsDemo {
    public static void main(String[] args) {
        // Zugriff auf einzelne Enum-Werte
        Wochentag tag = Wochentag.MONTAG;
        System.out.println("Tag: " + tag.getName());
        System.out.println("Ist Arbeitstag? " + tag.istArbeitstag());

        // Iteration über alle Enum-Werte
        for (Wochentag w : Wochentag.values()) {
            System.out.println(w.getName() + " - Ist Arbeitstag? " + w.istArbeitstag());
        }

        // Verwendung von Methoden auf Enums
        Wochentag dienstag = Wochentag.DIENSTAG;
        dienstag.printInfo();
    }
}
