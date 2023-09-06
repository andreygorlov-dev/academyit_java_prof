package lesson3.decorator;

public class Truck implements ICar {

    private final ICar car;

    public Truck(ICar car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed();
    }

    @Override
    public int getMaxWeightBaggage() {
        return this.car.getMaxWeightBaggage() + 2000;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "speed=" + getSpeed() +
                ", maxWeight=" + getMaxWeightBaggage() +
                '}';
    }
}
