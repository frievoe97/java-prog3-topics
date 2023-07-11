package observerPatternPropertyChangeSupport;

/**
 * Die Main-Klasse demonstriert die Verwendung des Observer Patterns.
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer = new Observer();

        subject.addObserver(observer);

        subject.setData("Hello, World!");

        subject.removeObserver(observer);

        subject.setData("Goodbye!");

    }
}
