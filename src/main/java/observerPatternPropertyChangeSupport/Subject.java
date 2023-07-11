package observerPatternPropertyChangeSupport;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Das Subjekt repräsentiert das zu beobachtende Objekt.
 */
class Subject {
    private String data;
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * Konstruktor für das Subjekt.
     */
    public Subject() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Setzt die Daten des Subjekts und benachrichtigt die Beobachter über die Änderung.
     *
     * @param newData die neuen Daten des Subjekts
     */
    public void setData(String newData) {
        String oldData = this.data;
        this.data = newData;
        propertyChangeSupport.firePropertyChange("data", oldData, newData);
    }

    /**
     * Fügt einen Beobachter zum Subjekt hinzu.
     *
     * @param observer der hinzuzufügende Beobachter
     */
    public void addObserver(PropertyChangeListener observer) {
        propertyChangeSupport.addPropertyChangeListener(observer);
    }

    /**
     * Entfernt einen Beobachter vom Subjekt.
     *
     * @param observer der zu entfernende Beobachter
     */
    public void removeObserver(PropertyChangeListener observer) {
        propertyChangeSupport.removePropertyChangeListener(observer);
    }
}