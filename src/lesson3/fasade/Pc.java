package lesson3.fasade;

public class Pc {

    private Proc proc;
    private Ram ram;
    private Hard hard;

    public Pc() {
        this.proc = new Proc();
        this.ram = new Ram();
        this.hard = new Hard();
    }

    public void on() {
        proc.compute();
        ram.load();
        hard.read();
    }

}
