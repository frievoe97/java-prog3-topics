package musterklausur;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Die Klasse WunderController ist der Controller für die Benutzeroberfläche des "Haus Tausender Wunder".
 * Sie erbt von der JavaFX Application-Klasse und implementiert das LagerBeobachter-Interface.
 * Der Controller ermöglicht die Interaktion mit der Benutzeroberfläche und die Steuerung der Anwendung.
 * Er verwaltet das "Haus Tausender Wunder" und stellt die Verbindung zwischen der Benutzeroberfläche und dem Modell her.
 *
 * @author Doro
 */
public final class WunderController extends Application implements LagerBeobachter {

    @FXML
    private TextArea txtGefaesse;
    @FXML
    private TextField txtPreisinhalt;
    @FXML
    private TextField txtLaenge;
    @FXML
    private TextField txtHoehe;
    @FXML
    private ChoiceBox<String> chbForm;
    @FXML
    private Label lblMeldung;
    @FXML
    private TextField txtGesamtpreis;

    private final HausTausenderWunder htw = new HausTausenderWunder();

    /**
     * Initialisiert die Benutzeroberfläche nach dem Laden des FXML-Dokuments.
     * Wird automatisch von JavaFX aufgerufen.
     * Fügt die möglichen Gefäßformen zur ChoiceBox hinzu und fügt den Controller als LagerBeobachter hinzu.
     * Bindet das Property für den Gesamtpreis an das Textfeld für die Anzeige.
     */
    @FXML
    private void initialize() {
        ObservableList<String> obs;
        obs = FXCollections.observableArrayList("Zylinder", "Quader", "Pyramide");
        chbForm.setItems(obs);
        chbForm.getSelectionModel().selectFirst();
        htw.beobachterHinzufuegen(this);
        this.txtGesamtpreis.textProperty().bind(this.htw.gesamtpreisProperty().asString());
    }

    /**
     * Aktualisiert die Anzeige der Gefäßliste im TextArea auf der Benutzeroberfläche.
     * Da JavaFX-Elemente nur auf dem JavaFX Application Thread aktualisiert werden dürfen,
     * wird die Aktualisierung mit Platform.runLater() durchgeführt.
     *
     * @param text Der zu aktualisierende Text.
     */
    private void listeAktualisieren(String text) {
        Platform.runLater(() -> {
            txtGefaesse.setText(text);
        });
    }

    /**
     * Startet die Produktion von Gefäßen basierend auf den eingegebenen Werten
     * für den Preis des Inhalts, die Länge und die Höhe.
     * Die Produktion erfolgt mithilfe einer Gefäßfabrik, die zufällig Gefäße erstellt.
     * Aktualisiert die Benutzeroberfläche mit einer Meldung über den Start der Produktion.
     */
    public void starten() {
        double preisInhalt;
        double laenge;
        double hoehe;
        try {
            preisInhalt = Double.parseDouble(txtPreisinhalt.getText());
            laenge = Double.parseDouble(txtLaenge.getText());
            hoehe = Double.parseDouble(txtHoehe.getText());
            Gefaessfabrik fabrik = new Zufallsgefaessfabrik();
            htw.produktionStarten(fabrik, preisInhalt, laenge, hoehe);
            lblMeldung.setText("Produktion läuft");
        } catch (NumberFormatException e) {
            lblMeldung.setText("Keine Zahl!");
        }
    }

    /**
     * Stoppt die Produktion von Gefäßen.
     * Aktualisiert die Benutzeroberfläche mit einer Meldung über den gestoppten Produktionsvorgang.
     */
    public void stoppen() {
        htw.produktionStoppen();
        lblMeldung.setText("Produktion gestoppt");
    }

    /**
     * Kauft ein ausgewähltes Gefäß basierend auf den eingegebenen Werten für Länge, Höhe und Preis des Inhalts.
     * Das ausgewählte Gefäß wird anhand des Inhalts der ChoiceBox ermittelt.
     * Wenn das Gefäß vorhanden ist, wird es aus dem Lager entnommen und der Gesamtpreis wird aktualisiert.
     * Bei Fehlern (z. B. keine Zahl eingegeben oder Gefäß nicht vorhanden) wird eine entsprechende Meldung angezeigt.
     */
    public void kaufen() {
        try {
            double laenge = Double.parseDouble(txtLaenge.getText());
            double hoehe = Double.parseDouble(txtHoehe.getText());
            double preis = Double.parseDouble(txtPreisinhalt.getText());

            String form = chbForm.getValue();
            Gefaess gefaess = null;
            switch (form) {
                case "Zylinder":
                    gefaess = new Zylinder(preis, laenge, hoehe);
                    break;
                case "Quader":
                    gefaess = new Quader(preis, laenge, hoehe);
                    break;
                case "Pyramide":
                    gefaess = new Pyramide(preis, laenge, hoehe);
                    break;
            }
            htw.gefaessKaufen(gefaess);
        } catch (NichtVorhandenException e) {
            lblMeldung.setText("Gefaess nicht vorhanden!");
            return;
        } catch (NumberFormatException e) {
            lblMeldung.setText("Keine Zahl");
            return;
        }
        lblMeldung.setText("");
    }

    /**
     * Implementiert die Methode aus dem LagerBeobachter-Interface.
     * Wird aufgerufen, wenn sich der Lagerbestand ändert.
     * Aktualisiert die Anzeige der Gefäßliste auf der Benutzeroberfläche.
     */
    @Override
    public void lagerGeaendert() {
        this.listeAktualisieren(htw.getGefaessliste());
    }

    /**
     * Startet die JavaFX-Anwendung und zeigt die Benutzeroberfläche an.
     * Die Methode wird von der Application-Klasse aufgerufen.
     *
     * @param stage Die Hauptbühne (Stage) für die JavaFX-Anwendung.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Laden des FXML-Dokuments und Setzen des Controllers
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WunderOberflaeche.fxml"));
        loader.setController(this);
        Parent lc = loader.load();
        Scene scene = new Scene(lc, 400, 400);
        stage.setTitle("HTW");
        stage.setScene(scene);
        stage.show();

        // Verhalten beim Schließen des Fensters
        stage.setOnCloseRequest(e -> {
            this.htw.produktionStoppen();
            this.htw.beobachterEntfernen(this);
            stage.close();
        });
    }
}
