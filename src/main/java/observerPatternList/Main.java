package observerPatternList;

// Hauptklasse
public class Main {
    public static void main(final String[] args) {
        // Beobachtetes Objekt erstellen
        Subject subject = new Subject();

        // Beobachter hinzufügen
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Aktion ausführen und Beobachter benachrichtigen
        subject.performAction();

        // Beobachter entfernen
        subject.removeObserver(observer1);

        // Aktion erneut ausführen und verbleibenden Beobachter benachrichtigen
        subject.performAction();
    }
}
