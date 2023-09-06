package lesson2.abstract_factory;

public class LanchFirst extends AbstractFactory {

    @Override
    public Food createFood() {
        return new Food("Бургер");
    }

    @Override
    public Drink createDrink() {
        return new Drink("Коффе");
    }
}
