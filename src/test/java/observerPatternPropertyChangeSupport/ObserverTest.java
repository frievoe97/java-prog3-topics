package observerPatternPropertyChangeSupport;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;

public class ObserverTest {

    @Test
    public void testObserverNotification() {
        // Erstelle das Subjekt
        Subject subject = new Subject();

        // Erstelle einen Mock-Beobachter mit Mockito
//        PropertyChangeListener observer = Mockito.mock(PropertyChangeListener.class);
        Observer observer = Mockito.mock(Observer.class);

        // Füge den Mock-Beobachter dem Subjekt hinzu
        subject.addObserver(observer);

        // Ändere die Daten im Subjekt
        subject.setData("Test Data");

        // Überprüfe, ob der Beobachter mindestens einmal benachrichtigt wurde
        verify(observer, times(1)).propertyChange(Mockito.any());

        // Entferne den Beobachter aus dem Subjekt
        subject.removeObserver(observer);

        // Ändere erneut die Daten im Subjekt
        subject.setData("Another Data");

        // Überprüfe, ob der Beobachter nicht mehr benachrichtigt wird (geht nicht...)
        verifyNoMoreInteractions(observer);
    }
}
