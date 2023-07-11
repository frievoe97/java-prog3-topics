package abstract_factory_pattern;

// Der Client
public class Client {
    public static void main(String[] args) throws InterruptedException {
        AbstractObservableFactory factory = new ConcreteObservableFactory();
        Observable observable = factory.createObservable();

        // Der Client interagiert mit dem beobachteten Objekt, ohne den konkreten Typ zu kennen
        observable.notifyObserver();
    }
}
