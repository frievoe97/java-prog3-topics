package templateMethod;

// Abstrakte Klasse
abstract class AbstractClass {
    // Template-Methode
    public void templateMethod() {
        // Aufruf der abstrakten Methoden
        stepOne();
        stepTwo();

        // Aufruf der konkreten Methode
        stepThree();
    }

    // Abstrakte Methode, die von den konkreten Klassen implementiert werden muss
    abstract void stepOne();

    // Abstrakte Methode, die von den konkreten Klassen implementiert werden muss
    abstract void stepTwo();

    // Konkrete Methode mit einer Standardimplementierung
    void stepThree() {
        System.out.println("Step Three (Default Implementation)");
    }
}
