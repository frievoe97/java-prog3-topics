package musterklausur;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class HausTausenderWunderTest {

    @Test
    void testObserverNotification() {
        // Erzeuge einen Mock für den Beobachter
        LagerBeobachter lagerBeobachter = Mockito.mock(LagerBeobachter.class);

        // Erzeuge das beobachtete Objekt
        HausTausenderWunder hausTausenderWunder = new HausTausenderWunder();
        hausTausenderWunder.beobachterHinzufuegen(lagerBeobachter);

        // Führe die Aktion aus
        hausTausenderWunder.benachrichtigen();

        // Überprüfe, ob der Beobachter benachrichtigt wurde
        verify(lagerBeobachter, times(1)).lagerGeaendert();

        // Entferne den Beobachter
        hausTausenderWunder.beobachterEntfernen(lagerBeobachter);

        // Führe die Aktion erneut aus
        hausTausenderWunder.benachrichtigen();

        // Überprüfe, ob der Beobachter nicht erneut benachrichtigt wurde
        verifyNoMoreInteractions(lagerBeobachter);
    }

}