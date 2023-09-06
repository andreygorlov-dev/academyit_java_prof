package lesson3.adapter;

public class Car implements ITransport {

    @Override
    public void move() {
        System.out.println("Авто движется по дороге");
    }

}
