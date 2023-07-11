package hashMap;

// Auto.java
public class Auto implements Fortbewegungsmittel {
    @Override
    public void bewegen() {
        System.out.println("Das Auto fährt auf der Straße.");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
