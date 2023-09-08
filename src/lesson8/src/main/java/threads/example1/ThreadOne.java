package threads.example1;

public class ThreadOne {

    public ThreadOne() {
        System.out.println("Сообщение до вызова метода");
        test();
        System.out.println("До окончкание выполнения метода test");
    }

    private void test() {
        int x = 0;
        while (x < 1000000) {
            x++;
        }

        System.out.println(x);
    }

    public static void main(String[] args) {
        new ThreadOne();
    }
}
