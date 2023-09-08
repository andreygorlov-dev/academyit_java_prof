package threads.executors;

public class LambdaRunnable {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Выполняем задачу 1");
            }
        };

        Runnable task1 = () -> {
            System.out.println("Выполняем задачу 1");
        };
        Runnable task2 = () -> {
            System.out.println("Выполняем задачу 2");
        };
        Runnable task3 = () -> {
            System.out.println("Выполняем задачу 3");
        };
        Runnable task4 = () -> {
            System.out.println("Выполняем задачу 4");
        };

        Runnable[] array = {task1, task2, task3, task4};

        for (int i = 0; i < 4; i++) {
            new Thread(array[i]).start();
        }

    }

}
