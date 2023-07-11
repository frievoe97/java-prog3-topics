package serialisierung;

import java.io.Serial;
import java.io.Serializable;

class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final /*transient*/ String name; // Das transient-Schlüsselwort markiert das Attribut als nicht serialisierbar
    private final int alter;

    Person(final String name, final int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return this.name;
    }

    public int getAlter() {
        return this.alter;
    }
}
