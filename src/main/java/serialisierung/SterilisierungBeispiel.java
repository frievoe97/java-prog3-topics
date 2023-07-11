package serialisierung;

import java.io.*;

public class SterilisierungBeispiel {
    public static void main(String[] args) {
        Person person = new Person("Max Mustermann", 30);
        String dateiName = "person.ser";

        // Serialisierung
        serializePerson(person, dateiName);

        // Deserialisierung
        Person deserialisiertePerson = deserializePerson(dateiName);

        // Überprüfung der Deserialisierung
        System.out.println("Deserialisierte Person: " + deserialisiertePerson.getName() + ", " + deserialisiertePerson.getAlter());
    }

    private static void serializePerson(Person person, String dateiName) {
        try (OutputStream fileOutput = new FileOutputStream(dateiName);
             OutputStream buffer = new BufferedOutputStream(fileOutput);
             ObjectOutputStream outputStream = new ObjectOutputStream(buffer)) {

            outputStream.writeObject(person);
            outputStream.flush();
            System.out.println("Person wurde erfolgreich serialisiert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializePerson(String dateiName) {
        Person person = null;
        try (InputStream fileInput = new FileInputStream(dateiName);
             InputStream buffer = new BufferedInputStream(fileInput);
             ObjectInputStream inputStream = new ObjectInputStream(buffer)) {

            person = (Person) inputStream.readObject();
            System.out.println("Person wurde erfolgreich deserialisiert.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
