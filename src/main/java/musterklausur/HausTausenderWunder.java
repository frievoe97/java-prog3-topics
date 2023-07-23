package musterklausur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Diese Klasse stellt den Laden "Haus Tausender Wunder" dar, der
 * viele tolle Gefäße produziert und aus dem Lager heraus verkauft.
 *
 * @author Doro
 */
public class HausTausenderWunder {

    /**
     * Anzahl der Gefäße nach der Art des Gefäßes.
     */
    private final Map<Gefaess, Integer> lagerverwaltung = new HashMap<>();

    /**
     * Gesamtpreis des Lagerbestands.
     */
    private final DoubleProperty gesamtpreis = new SimpleDoubleProperty(0);

    /**
     * Property des Gesamtpreises.
     *
     * @return Property des Gesamtpreises.
     */
    public DoubleProperty gesamtpreisProperty() {
        return this.gesamtpreis;
    }

    /**
     * Thread für die Produktion neuer Gefäße.
     */
    private Thread produktionsThread;

    /**
     * Liste aller Beobachter.
     */
    private final List<LagerBeobachter> beobachter = new ArrayList<>();

    /**
     * startet die Endlosproduktion von Gefäßen der angegebenen Größe
     * mithilfe der Fabrik und fügt die erstellten Gefäße in die
     * Lagerverwaltung ein
     *
     * @param fabrik
     * @param preisInhalt
     * @param laenge
     * @param hoehe
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
     * stoppt alle laufenden Produktionen
     */
    public void produktionStoppen() {
        produktionsThread.interrupt();
    }

    /**
     * entnimmt das Gefäß g aus der Lagerverwaltung
     *
     * @param gefaess
     * @throws NichtVorhandenException, wenn g nicht im Lager vorhanden ist
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
     * fügt das Gefäß g in die Lagerverwaltung ein
     *
     * @param gefaess
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
     * liefert einen textuelle Liste aller Gefäße mit ihrer Anzahl zurück
     *
     * @return
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
     * @param lagerBeobachter
     */
    public void beobachterHinzufuegen(LagerBeobachter lagerBeobachter) {
        beobachter.add(lagerBeobachter);
    }

    /**
     * Entfernt einen Beobachter aus der Liste.
     *
     * @param lagerBeobachter
     */
    public void beobachterEntfernen(LagerBeobachter lagerBeobachter) {
        beobachter.remove(lagerBeobachter);
    }

    /**
     * Benachrcihtigt alle Beobachter über eine Änderung in der Lagerverwaltung.
     */
    public void benachrichtigen() {
        for (LagerBeobachter lagerBeobachter : beobachter) {
            lagerBeobachter.lagerGeaendert();
        }
    }

}
