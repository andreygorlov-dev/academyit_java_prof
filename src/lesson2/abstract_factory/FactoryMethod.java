package lesson2.abstract_factory;

public class FactoryMethod {

    public static AbstractFactory getFactory(int numberLanch) {
        if (numberLanch == 1) {
            return new LanchFirst();
        } else if (numberLanch == 2) {
            return new LanchSecond();
        }
        return null;
    }

}
