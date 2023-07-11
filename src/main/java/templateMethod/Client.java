package templateMethod;

// Der Client
public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass1 = new ConcreteClass1();
        abstractClass1.templateMethod();

        AbstractClass abstractClass2 = new ConcreteClass2();
        abstractClass2.templateMethod();

        AbstractClass abstractClass3 = new ConcreteClass3();
        abstractClass3.templateMethod();
    }
}
