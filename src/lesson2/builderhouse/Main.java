package lesson2.builderhouse;

public class Main {

    public static void main(String[] args) {
        House house = House.Builder.newInstance()
                .setSwimmingPool(false)
                .setGarage(true)
                .setFencing(false)
                .setSquare(234.5)
                .setType(House.Type.COTTAGE)
                .setWindow(4, Window.Type.PLASTIC)
                .build();

        System.out.println(house);
    }

}
