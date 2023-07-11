package abstract_factory_pattern;

// Konkrete Implementierung des beobachteten Objekts
class ConcreteObservable extends Observable {
    @Override
    void notifyObserver() {
        System.out.println("Das beobachtete Objekt wurde aktualisiert!");
    }
}
