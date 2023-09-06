package generics.v2;

public class Demo<T> {

    public void showArray(T[] items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

}