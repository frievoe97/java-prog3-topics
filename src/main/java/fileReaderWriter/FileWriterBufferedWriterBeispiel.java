package fileReaderWriter;

import java.io.*;

public class FileWriterBufferedWriterBeispiel {
    public static void main(String[] args) {
        String dateiName = "textdatei.txt";
        String text = "Dies ist ein Beispieltext.";

        // FileWriter und BufferedWriter verwenden
        try (FileWriter fileWriter = new FileWriter(dateiName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(text);
            bufferedWriter.newLine(); // Neue Zeile einfügen
            bufferedWriter.write("Weitere Zeile.");

            System.out.println("Text wurde erfolgreich in die Datei geschrieben.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileReader und BufferedReader verwenden
        try (FileReader fileReader = new FileReader(dateiName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            System.out.println("Inhalt der Datei:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

