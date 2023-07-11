package observerPatternList;

// Beobachter 1
class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("Observer 1 wurde aktualisiert.");
    }
}
