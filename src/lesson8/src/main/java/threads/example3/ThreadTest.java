package threads.example3;

public class ThreadTest extends Thread {

    public ThreadTest(String title) {
        setName(title);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.getName());
            try {
                sleep((long) Math.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + "  finish");
    }

    public static void main(String[] args) {
        new ThreadTest("#1").start();
        new ThreadTest("#2").start();
        new ThreadTest("#3").start();
        new ThreadTest("#4").start();
        new ThreadTest("#5").start();
    }
}
