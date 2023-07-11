package generics;

/**
 * Eine generische Klasse, die einen beliebigen Datentyp T speichern kann.
 */
class Box<T> {
    private T inhalt;

    public void setInhalt(T inhalt) {
        this.inhalt = inhalt;
    }

    public T getInhalt() {
        return inhalt;
    }
}
