package lesson2.factory;

public class Cappuchino extends Coffe {

    public Cappuchino() {
        grind();
        makeCoffee();
        passCoffee();
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        System.out.println("Добавляем молоко");
    }
}
