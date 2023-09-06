package lesson2.abstract_factory;

public class LanchSecond extends AbstractFactory {

    @Override
    public Food createFood() {
        return new Food("Пицца");
    }

    @Override
    public Drink createDrink() {
        return new Drink("Сок");
    }
}
