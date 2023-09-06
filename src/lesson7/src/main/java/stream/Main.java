package stream;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        Arrays.stream(arr).filter(x -> x < 90).map(x -> x + 10).limit(3).forEach(System.out::print);
    }

}
