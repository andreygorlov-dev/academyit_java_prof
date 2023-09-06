package lesson3.adapter;

public class Ship implements ITransport {

    @Override
    public void move() {
        System.out.println("Корабль плывет");
    }

}
