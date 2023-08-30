package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class BinSearch {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Введите количество элементов");
            int size = sc.nextInt();
            int arr[] = new int[size];

            System.out.println("Введите элементы");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Введите искомый элемент");

            int item = sc.nextInt();

            Arrays.sort(arr);

            System.out.println(Arrays.toString(arr));

            int first = 0;
            int last = size - 1;
            search(arr, first, last, item);
        }
    }

    private static void search(int[] arr, int first, int last, int item) {
        int position = (first + last) / 2;
        while (arr[position] != item && first <= last) {
            if (arr[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println("Элемент " + (position + 1) + " месте");
        } else {
            System.out.println("Элемент не найден");
        }
    }

}
