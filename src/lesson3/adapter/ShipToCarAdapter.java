package lesson3.adapter;

public class ShipToCarAdapter implements ITransport {

    private Ship ship;

    public ShipToCarAdapter(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void move() {
        ship.move();
    }
}
