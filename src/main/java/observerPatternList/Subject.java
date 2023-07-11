package observerPatternList;

import java.util.ArrayList;
import java.util.List;

class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(final Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void performAction() {
        // Aktion ausführen
        System.out.println("Aktion wurde ausgeführt.");
        // Beobachter benachrichtigen
        notifyObservers();
    }
}
