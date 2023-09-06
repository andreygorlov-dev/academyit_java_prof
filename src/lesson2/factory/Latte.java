package lesson2.factory;

public class Latte extends Coffe {

    public Latte() {
        grind();
        makeCoffee();
        passCoffee();
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        System.out.println("Добавляем мног молоко");
    }

}
