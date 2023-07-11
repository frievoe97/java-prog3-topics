package threads;

public class ThreadExample {
    public static void main(String[] args) {
        // Thread-Objekt erstellen
        MyThread thread = new MyThread();

        // Thread starten
        thread.start();

        // Hauptthread-Ausgabe
        for (int i = 0; i < 5; i++) {
            System.out.println("Hauptthread: " + i);
            try {
                Thread.sleep(1000); // Eine Sekunde warten
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
