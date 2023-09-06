package lesson3.adapter;

public class Main {

    public static void main(String[] args) {
        Traveller man = new Traveller();
        ITransport car = new Car();

        man.travel(car);

        Ship ship = new Ship();

        ITransport shipTransport = new ShipToCarAdapter(ship);
        man.travel(shipTransport);
        man.travel(ship);
    }

}
