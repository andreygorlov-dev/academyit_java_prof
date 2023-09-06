package lesson2.abstract_factory;

public class Main {

    public static void main(String[] args) {
        AbstractFactory factory = FactoryMethod.getFactory(1);
        System.out.println("В важ заказ входиь: " + factory.createFood().getTitle() + " &" + factory.createDrink().getTitle());
        AbstractFactory factory2 = FactoryMethod.getFactory(2);
        System.out.println("В важ заказ входиь: " + factory2.createFood().getTitle() + " &" + factory2.createDrink().getTitle());

    }

}
