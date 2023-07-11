package hashMap;

import java.util.HashMap;
import java.util.Map;

// Main.java
public class Main {

    private static final Map<Class<? extends Fortbewegungsmittel>, Integer> alleFortbewegungsmittel = new HashMap<>();

    public static void main(String[] args) {
        Fortbewegungsmittel auto = new Auto(); // Beispielobjekt
        Fortbewegungsmittel auto2 = new Auto(); // Beispielobjekt
        Fortbewegungsmittel auto3 = new Auto(); // Beispielobjekt
        Fortbewegungsmittel auto4 = new Auto(); // Beispielobjekt
        Fortbewegungsmittel fahrrad = new Fahrrad(); // Beispielobjekt

        addFortbewegungsmittel(auto); // Auto hinzufügen
        addFortbewegungsmittel(fahrrad); // Fahrrad hinzufügen
        addFortbewegungsmittel(auto2); // Auto erneut hinzufügen
        addFortbewegungsmittel(auto3); // Auto erneut hinzufügen
        addFortbewegungsmittel(auto4); // Auto erneut hinzufügen

        printAlleFortbewegungsmittel();

        removeFortbewegungsmittel(auto);
        removeFortbewegungsmittel(auto2);
        removeFortbewegungsmittel(auto3);
        removeFortbewegungsmittel(auto4);

        printAlleFortbewegungsmittel();
    }

    private static void addFortbewegungsmittel(Fortbewegungsmittel fortbewegungsmittel) {
        Class<? extends Fortbewegungsmittel> key = fortbewegungsmittel.getClass();
        if (alleFortbewegungsmittel.containsKey(key)) {
            int value = alleFortbewegungsmittel.get(key);
            alleFortbewegungsmittel.put(key, value + 1);
        } else {
            alleFortbewegungsmittel.put(key, 1);
        }
    }

    private static void removeFortbewegungsmittel(Fortbewegungsmittel fortbewegungsmittel) {
        Class<? extends Fortbewegungsmittel> key = fortbewegungsmittel.getClass();
        if (alleFortbewegungsmittel.containsKey(key)) {
            int value = alleFortbewegungsmittel.get(key);
            if (value > 1) {
                alleFortbewegungsmittel.put(key, value - 1); // Wert um 1 verringern
            } else {
                alleFortbewegungsmittel.remove(key); // Wertepaar löschen
            }
        }
    }

    private static void printAlleFortbewegungsmittel() {
        System.out.println("Alle Fortbewegungsmittel:");
        for (Map.Entry<Class<? extends Fortbewegungsmittel>, Integer> entry : alleFortbewegungsmittel.entrySet()) {
            System.out.println(entry.getKey().getSimpleName() + " " + entry.getValue());
        }
    }
}
