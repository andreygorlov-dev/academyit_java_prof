package lesson2.builder;

public class Main {

    public static void main(String[] args) {
        Car car = Car.Builder.newInstance()
                .setTitle("Porshe")
                .setBody(Body.Color.BLACK, Body.Type.LIFTBACK)
                .setEngine(10, 2)
                .setWheels(Wheels.Type.WINTER, true)
                .build();
        car.startEngine();
        System.out.println(car);
        car.stopEngine();
        System.out.println(car);

    }

}
