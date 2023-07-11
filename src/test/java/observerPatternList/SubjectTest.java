package observerPatternList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class SubjectTest {

    @Test
    void testObserverNotification() {
        // Erzeuge einen Mock für den Beobachter
        Observer observer = Mockito.mock(Observer.class);

        // Erzeuge das beobachtete Objekt
        Subject subject = new Subject();
        subject.addObserver(observer);

        // Führe die Aktion aus
        subject.performAction();

        // Überprüfe, ob der Beobachter benachrichtigt wurde
        verify(observer, times(1)).update();

        // Entferne den Beobachter
        subject.removeObserver(observer);

        // Führe die Aktion erneut aus
        subject.performAction();

        // Überprüfe, ob der Beobachter nicht erneut benachrichtigt wurde
        verifyNoMoreInteractions(observer);
    }
}
