package templateMethod;

// Konkrete Implementierung 3
class ConcreteClass3 extends AbstractClass {
    @Override
    void stepOne() {
        System.out.println("ConcreteClass3: Step One");
    }

    @Override
    void stepTwo() {
        System.out.println("ConcreteClass3: Step Two");
    }

    @Override
    void stepThree() {
        System.out.println("ConcreteClass3: Step Three");
    }
}
