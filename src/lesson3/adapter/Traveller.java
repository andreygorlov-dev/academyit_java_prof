package lesson3.adapter;

public class Traveller {

    public void travel(ITransport transport) {
        transport.move();
    }

}
