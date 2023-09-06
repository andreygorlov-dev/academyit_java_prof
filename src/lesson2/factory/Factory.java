package lesson2.factory;

public class Factory {

    static Coffe factoryMethod(TypeCoffe typeCoffe) {
        switch (typeCoffe) {
            case LATTE:
                return new Latte();
            case CAPPUCHINO:
                return new Cappuchino();
            case AMERICANO:
                return new Americano();
            default:
                return null;

        }
    }

}
