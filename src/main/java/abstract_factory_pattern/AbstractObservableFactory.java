package abstract_factory_pattern;

// Abstrakte Fabrik zum Erzeugen des beobachteten Objekts
abstract class AbstractObservableFactory {
    abstract Observable createObservable();
}
