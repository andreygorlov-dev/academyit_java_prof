package threads.example2;

public class ThreadSecond {

    private String titleThread;

    public ThreadSecond(final String titleThread) {
        this.titleThread = titleThread;
        new Thread() {
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
        }.start();
    }

    public static void main(String[] args) {

        new ThreadSecond("1");
        new ThreadSecond("2");

    }
}
