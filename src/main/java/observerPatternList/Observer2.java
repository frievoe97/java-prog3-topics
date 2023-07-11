package observerPatternList;

// Beobachter 2
class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("Observer 2 wurde aktualisiert.");
    }
}
