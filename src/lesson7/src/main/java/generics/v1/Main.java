package generics.v1;

public class Main {

    public static void main(String[] args) {
        Account<String> billFirst = new Account<>("Test", 10000);
        System.out.println(billFirst);

        Account<Integer> billSecond = new Account<>(12, 12312);
        System.out.println(billSecond);
    }

}
