package lesson2.builder;

public class Engine {

    private final int power;
    private final int volume;

    public Engine(int power, int volume) {
        this.power = power;
        this.volume = volume;
    }

    public void on() {
        System.out.println("Двигатель запущен");
    }

    public void off() {
        System.out.println("Двигатель выключен");
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", volume=" + volume +
                '}';
    }
}
