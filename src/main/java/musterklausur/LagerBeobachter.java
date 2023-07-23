package musterklausur;

/**
 * Das Interface `LagerBeobachter` dient dem Observer Pattern, bei dem Objekte
 * Änderungen an einem bestimmten Subjekt (Lager) verfolgen können.
 * <p>
 * Ein Objekt, das dieses Interface implementiert, kann als Beobachter für das Lager
 * dienen und wird über Änderungen im Lagerbestand informiert, indem die Methode
 * `lagerGeaendert()` aufgerufen wird.
 * <p>
 * Die Klasse `HausTausenderWunder` enthält eine Liste von LagerBeobachter-Objekten,
 * die über Änderungen im Lager informiert werden, wenn neue Gefäße hinzugefügt oder
 * vorhandene Gefäße gekauft werden.
 * <p>
 * Um das Observer Pattern zu implementieren, muss eine Klasse dieses Interface
 * implementieren und die gewünschten Aktionen in der Methode `lagerGeaendert()` ausführen,
 * wenn sie benachrichtigt wird.
 * <p>
 * LagerBeobachter meinBeobachter = new MeinBeobachter();
 * hausTausenderWunder.beobachterHinzufuegen(meinBeobachter);
 * <p>
 * Wenn nun das Lager aktualisiert wird (z.B. durch Hinzufügen oder Kaufen von Gefäßen),
 * wird die `lagerGeaendert()`-Methode des `MeinBeobachter`-Objekts aufgerufen und die
 * entsprechenden Aktionen werden ausgeführt.
 * <p>
 * Beachte: Das Interface enthält nur eine Methode, die die Beobachter informiert,
 * ohne zusätzliche Argumente. Bei Bedarf können weitere Informationen im Lagerbeobachter
 * implementiert werden, indem zusätzliche Parameter an die `lagerGeaendert()`-Methode
 * hinzugefügt werden.
 *
 * @author frievoe97
 * @see HausTausenderWunder
 * @see HausTausenderWunder#beobachterHinzufuegen(LagerBeobachter)
 * @see HausTausenderWunder#benachrichtigen()
 * @see LagerBeobachter#lagerGeaendert()
 */
interface LagerBeobachter {
    /**
     * Wird aufgerufen, wenn Änderungen im Lagerbestand festgestellt werden.
     * Implementierende Klassen sollten die gewünschten Aktionen in dieser Methode ausführen.
     */
    void lagerGeaendert();
}
