package lesson3.decorator;

public class SportCar implements ICar {

    private final ICar car;

    public SportCar(ICar car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed() + 250;
    }

    @Override
    public int getMaxWeightBaggage() {
        return this.car.getMaxWeightBaggage();
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + getSpeed() +
                ", maxWeight=" + getMaxWeightBaggage() +
                '}';
    }
}
