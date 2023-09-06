package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list, "C++", "C#", "C#", "Java", "Java", "Python");
        list.stream().filter(x -> x.length() > 2).forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        List<String> uniqItems = list.stream().distinct().collect(Collectors.toList());

        uniqItems.forEach(System.out::println);

        List<Integer> sizeLangs = list.stream().map(item -> item.length()).collect(Collectors.toList());

        System.out.println(sizeLangs);

        System.out.println(sizeLangs.stream().filter(x -> x == 4).findFirst());
        System.out.println(sizeLangs.stream().filter(x -> x == 5).findFirst().orElse(-1));
    }

}
