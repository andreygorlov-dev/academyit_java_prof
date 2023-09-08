package threads.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LambdaCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable task1 = () -> {
            double sum = 0 ;
            for (int i = 0; i < 1000; i++) {
                sum += Math.random();
            }
            return sum;
        };
        Callable task2 = () -> {
            double sum = 1 ;
            for (int i = 0; i < 100; i++) {
                sum *= Math.random();
            }
            return sum;
        };

        FutureTask <Double> resTask1 = new FutureTask<>(task1);
        FutureTask <Double> resTask2 = new FutureTask<>(task2);

        new Thread(resTask1).start();
        new Thread(resTask2).start();

        System.out.println(resTask1.get());
        System.out.println(resTask2.get());
    }

}
