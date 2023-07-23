package TemplateMethodBurger;

public class BeefBurgerRestaurant extends Restaurant{

    //Implementation der abstrakten Methode aus dem Restaurant
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
