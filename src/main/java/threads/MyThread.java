package threads;

// Eigene Thread-Klasse
class MyThread extends Thread {
    @Override
    public void run() {
        // Thread-Ausgabe
        for (int i = 0; i < 20; i++) {
            System.out.println("Eigenes Thread-Objekt: " + i);
            try {
                Thread.sleep(500); // Eine Sekunde warten
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
