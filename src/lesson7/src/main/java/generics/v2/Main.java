package generics.v2;

public class Main {

    public static void main(String[] args) {
        Demo demo = new Demo();

        String[] fio = {
                "Ivanov",
                "Petrov"
        };

        Integer[] ages = {
                22,
                33,
                44
        };

        demo.showArray(fio);
        demo.showArray(ages);
    }

}
