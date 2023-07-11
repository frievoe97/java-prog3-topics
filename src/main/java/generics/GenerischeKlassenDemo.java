package generics;

/**
 * Hauptklasse, die die generische Klasse verwendet und demonstriert.
 */
public class GenerischeKlassenDemo {
    public static void main(String[] args) {
        // Erstellen einer Box für Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.setInhalt(42);

        // Erstellen einer Box für String
        Box<String> stringBox = new Box<>();
        stringBox.setInhalt("Hallo, Welt!");

        // Abrufen des Inhalts der Boxen
        Integer integerInhalt = integerBox.getInhalt();
        String stringInhalt = stringBox.getInhalt();

        // Ausgabe des Inhalts
        System.out.println("Inhalt der integerBox: " + integerInhalt);
        System.out.println("Inhalt der stringBox: " + stringInhalt);
    }
}