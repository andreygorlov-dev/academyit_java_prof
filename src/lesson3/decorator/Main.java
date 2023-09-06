package lesson3.decorator;

public class Main {

    public static void main(String[] args) {
        ICar car = new BaseCar();
        System.out.println(car);

        ICar sportCar = new SportCar(car);
        System.out.println(sportCar);

        ICar truck = new Truck(car);
        System.out.println(truck);

    }

}
