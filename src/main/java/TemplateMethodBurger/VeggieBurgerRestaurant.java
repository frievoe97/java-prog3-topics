package TemplateMethodBurger;

public class VeggieBurgerRestaurant extends Restaurant{

    //Implementation der abstrakten Methode aus dem Restaurant
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
