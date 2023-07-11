package hashMap;

// Fahrrad.java
public class Fahrrad implements Fortbewegungsmittel {
    @Override
    public void bewegen() {
        System.out.println("Das Fahrrad fährt auf dem Fahrradweg.");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
