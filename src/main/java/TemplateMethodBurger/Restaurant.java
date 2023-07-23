package TemplateMethodBurger;
//Siehe: https://www.youtube.com/watch?v=EdFq_JIThqM
public abstract class Restaurant {

    //Nicht abstrakte Methode, welche abstrakte Methode verwendet
    public Burger orderBurger(){
        //Verwendung der abstrakten methode
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    //Deklarierung der abstrakten Methode
    public abstract Burger createBurger();
}
