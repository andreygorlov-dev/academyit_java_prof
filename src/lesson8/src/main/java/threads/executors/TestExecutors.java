package threads.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println(executor.submit(() -> {
            double sum = 0 ;
            for (int i = 0; i < 1000; i++) {
                sum += Math.random();
            }
            return sum;
        }).get());

        executor.shutdown();

    }

}
