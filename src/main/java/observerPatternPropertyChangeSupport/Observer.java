package observerPatternPropertyChangeSupport;

import java.beans.PropertyChangeListener;

/**
 * Der Beobachter implementiert das PropertyChangeListener-Interface und wird über Änderungen im Subjekt benachrichtigt.
 */
class Observer implements PropertyChangeListener {
    /**
     * Wird aufgerufen, wenn eine Eigenschaft des beobachteten Subjekts geändert wird.
     *
     * @param evt das PropertyChangeEvent-Objekt, das Informationen über die Änderung enthält
     */
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        System.out.println("Received new data: " + evt.getNewValue());
    }
}
