package hashMap;

// Bahn.java
public class Bahn implements Fortbewegungsmittel {
    @Override
    public void bewegen() {
        System.out.println("Die Bahn fährt auf den Schienen.");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
