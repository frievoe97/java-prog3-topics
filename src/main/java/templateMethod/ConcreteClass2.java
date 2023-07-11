package templateMethod;

// Konkrete Implementierung 2
class ConcreteClass2 extends AbstractClass {
    @Override
    void stepOne() {
        System.out.println("ConcreteClass2: Step One");
    }

    @Override
    void stepTwo() {
        System.out.println("ConcreteClass2: Step Two");
    }

    @Override
    void stepThree() {
        System.out.println("ConcreteClass2: Step Three");
    }
}
