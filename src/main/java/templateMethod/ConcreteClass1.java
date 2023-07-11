package templateMethod;

// Konkrete Implementierung 1
class ConcreteClass1 extends AbstractClass {
    @Override
    void stepOne() {
        System.out.println("ConcreteClass1: Step One");
    }

    @Override
    void stepTwo() {
        System.out.println("ConcreteClass1: Step Two");
    }
}
