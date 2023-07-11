package abstract_factory_pattern;

// Konkrete Fabrik zum Erzeugen der konkreten Implementierung des beobachteten Objekts
class ConcreteObservableFactory extends AbstractObservableFactory {
    @Override
    Observable createObservable() {
        return new ConcreteObservable();
    }
}
