package lesson2.factory;

public class Order {

    public Coffe makeOrder(TypeCoffe typeCoffe) {
        Coffe coffe = Factory.factoryMethod(typeCoffe);
        if (coffe != null) {
            System.out.println("Complete " + typeCoffe.name());
        } else {
            System.out.println("Error");
        }
        return coffe;
    }

}
