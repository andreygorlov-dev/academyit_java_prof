package lesson3.decorator;

public class BaseCar implements ICar {

    private int speed = 40;
    private int maxWeight = 200;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMaxWeightBaggage() {
        return maxWeight;
    }

    public BaseCar setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public BaseCar setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        return this;
    }

    @Override
    public String toString() {
        return "BaseCar{" +
                "speed=" + getSpeed() +
                ", maxWeight=" + getMaxWeightBaggage() +
                '}';
    }
}
