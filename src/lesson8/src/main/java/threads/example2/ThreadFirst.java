package threads.example2;


public class ThreadFirst extends Thread {

    public static void main(String[] args) {
        ThreadFirst threadFirst1 = new ThreadFirst("Первый");
        ThreadFirst threadFirst2 = new ThreadFirst("Второй");

        threadFirst1.start();
        threadFirst2.start();

    }

    private String titleThread;

    public ThreadFirst(String titleThread) {
        super();
        this.titleThread = titleThread;
    }

    @Override
    public void run() {
        int i = 1;

        while (i <= 18) {
            System.out.println(i + " " + titleThread);
            i++;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
