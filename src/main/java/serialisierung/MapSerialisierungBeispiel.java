package serialisierung;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MapSerialisierungBeispiel {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        String dateiName = "map.ser";

        // Serialisierung
        serializeMap(map, dateiName);

        // Deserialisierung
        Map<String, Integer> deserialisierteMap = deserializeMap(dateiName);

        // Überprüfung der Deserialisierung
        System.out.println("Deserialisierte Map: " + deserialisierteMap);
    }

    private static void serializeMap(Map<String, Integer> map, String dateiName) {
        try (OutputStream fileOutput = new FileOutputStream(dateiName);
             OutputStream buffer = new BufferedOutputStream(fileOutput);
             ObjectOutputStream outputStream = new ObjectOutputStream(buffer)) {

            outputStream.writeObject(map);
            outputStream.flush();
            System.out.println("Map wurde erfolgreich serialisiert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> deserializeMap(String dateiName) {
        Map<String, Integer> map = null;
        try (InputStream fileInput = new FileInputStream(dateiName);
             InputStream buffer = new BufferedInputStream(fileInput);
             ObjectInputStream inputStream = new ObjectInputStream(buffer)) {

            map = (Map<String, Integer>) inputStream.readObject();
            System.out.println("Map wurde erfolgreich deserialisiert.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}

