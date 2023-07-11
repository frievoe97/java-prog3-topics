package enums;

/**
 * Ein Enum zur Darstellung von Wochentagen.
 */
enum Wochentag {
    MONTAG("Montag", true),
    DIENSTAG("Dienstag", true),
    MITTWOCH("Mittwoch", true),
    DONNERSTAG("Donnerstag", true),
    FREITAG("Freitag", true),
    SAMSTAG("Samstag", false),
    SONNTAG("Sonntag", false);

    private final String name;
    private final boolean istArbeitstag;

    Wochentag(String name, boolean istArbeitstag) {
        this.name = name;
        this.istArbeitstag = istArbeitstag;
    }

    public String getName() {
        return name;
    }

    public boolean istArbeitstag() {
        return istArbeitstag;
    }

    public void printInfo() {
        System.out.println("Wochentag: " + name);
        System.out.println("Ist Arbeitstag? " + istArbeitstag);
    }
}