package musterklausur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Die Klasse HausTausenderWunder repräsentiert den Laden "Haus Tausender Wunder", der viele
 * tolle Gefäße produziert und aus dem Lager heraus verkauft. Das HausTausenderWunder-Objekt
 * verwaltet die Lagerverwaltung, startet und stoppt die Produktion von Gefäßen und benachrichtigt
 * Beobachter über Änderungen im Lagerbestand. Die Klasse implementiert das Observer Pattern
 * mit dem LagerBeobachter-Interface, um auf Änderungen im Lagerbestand zu reagieren. Sie ist
 * ein wichtiger Bestandteil des Abstract Factory Patterns, da sie die Gefäßproduktion und
 * Lagerverwaltung steuert. Die Gesamtsumme des Lagerbestands wird über ein DoubleProperty
 * gespeichert, um Beobachtern die Aktualisierung zu ermöglichen.
 *
 * @author Doro
 */
public class HausTausenderWunder {

    /**
     * Eine Map, die die Anzahl der Gefäße nach der Art des Gefäßes speichert.
     */
    private final Map<Gefaess, Integer> lagerverwaltung = new HashMap<>();

    /**
     * Das DoubleProperty, das den Gesamtpreis des Lagerbestands speichert.
     */
    private final DoubleProperty gesamtpreis = new SimpleDoubleProperty(0);

    /**
     * Gibt das DoubleProperty des Gesamtpreises zurück.
     *
     * @return Das DoubleProperty des Gesamtpreises.
     */
    public DoubleProperty gesamtpreisProperty() {
        return this.gesamtpreis;
    }

    /**
     * Thread für die Produktion neuer Gefäße.
     */
    private Thread produktionsThread;

    /**
     * Eine Liste aller Beobachter, die auf Änderungen im Lagerbestand reagieren.
     */
    private final List<LagerBeobachter> beobachter = new ArrayList<>();

    /**
     * Startet die Endlosproduktion von Gefäßen der angegebenen Größe mithilfe
     * der Fabrik und fügt die erstellten Gefäße in die Lagerverwaltung ein.
     *
     * @param fabrik      Die Gefäßfabrik, die zum Erstellen der Gefäße verwendet wird.
     * @param preisInhalt Der Preis pro cm³ des Inhalts der Gefäße.
     * @param laenge      Die Länge der zu produzierenden Gefäße.
     * @param hoehe       Die Höhe der zu produzierenden Gefäße.
     */
    public void produktionStarten(Gefaessfabrik fabrik, double preisInhalt,
                                  double laenge, double hoehe) {
        produktionsThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                this.gefaessEinfuegen(fabrik.erstelleGefaess(
                        laenge, hoehe, preisInhalt));
            }
        });
        produktionsThread.start();
    }

    /**
     * Stoppt alle laufenden Produktionen.
     */
    public void produktionStoppen() {
        produktionsThread.interrupt();
    }

    /**
     * Entnimmt das Gefäß g aus der Lagerverwaltung.
     *
     * @param gefaess Das Gefäß, das aus dem Lager entnommen werden soll.
     * @throws NichtVorhandenException Wenn das Gefäß nicht im Lager vorhanden ist.
     */
    public void gefaessKaufen(Gefaess gefaess) throws NichtVorhandenException {

        if (!this.lagerverwaltung.containsKey(gefaess)) {
            throw new NichtVorhandenException();
        } else {
            int anzahl = this.lagerverwaltung.remove(gefaess);
            if (anzahl > 1) {
                this.lagerverwaltung.put(gefaess, anzahl - 1);
            }
        }

        this.gesamtpreis.set(this.gesamtpreis.get() - gefaess.getPreis());
        this.benachrichtigen();
    }

    /**
     * Fügt das Gefäß g in die Lagerverwaltung ein.
     *
     * @param gefaess Das Gefäß, das in das Lager eingefügt werden soll.
     */
    protected void gefaessEinfuegen(Gefaess gefaess) {
        if (gefaess != null) {
            // TODO: Zu Beispielen hinzufügen
            this.lagerverwaltung.merge(gefaess, 1, Integer::sum);
            this.gesamtpreis.set(this.gesamtpreis.get() + gefaess.getPreis());
            this.benachrichtigen();
        }
    }

    /**
     * Liefert eine textuelle Liste aller Gefäße mit ihrer Anzahl im Lager zurück.
     *
     * @return Textuelle Liste aller Gefäße mit ihrer Anzahl.
     */
    public String getGefaessliste() {
        // TODO: Map Streams zu Beispielen hinzufügen
        return lagerverwaltung.entrySet().stream()
                .map(entry -> entry.getKey().getClass().getSimpleName() + ": "
                        + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Fügt einen neuen Beobachter hinzu.
     *
     * @param lagerBeobachter Der hinzuzufügende LagerBeobachter.
     */
    public void beobachterHinzufuegen(LagerBeobachter lagerBeobachter) {
        beobachter.add(lagerBeobachter);
    }

    /**
     * Entfernt einen Beobachter aus der Liste.
     *
     * @param lagerBeobachter Der zu entfernende LagerBeobachter.
     */
    public void beobachterEntfernen(LagerBeobachter lagerBeobachter) {
        beobachter.remove(lagerBeobachter);
    }

    /**
     * Benachrichtigt alle Beobachter über eine Änderung in der Lagerverwaltung.
     */
    public void benachrichtigen() {
        for (LagerBeobachter lagerBeobachter : beobachter) {
            lagerBeobachter.lagerGeaendert();
        }
    }

}
