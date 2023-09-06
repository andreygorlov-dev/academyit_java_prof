package lesson2.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Collections.addAll(items,
                new Item("Java для начинающих", "Содержимое ролика"),
                new Item("Spring для начинающих", "Содержимое ролика Spring"));
        Subject channel1 = new Subject("Блог программиста", items);
        Subject channel2 = new Subject("Блог админа", items);

        Observer observer1 = new Observer("Vasilii");
        Observer observer2 = new Observer("Anna");
        Observer observer3 = new Observer("Igor");

        channel1.addObserver(observer1);
        channel1.addObserver(observer2);
        channel1.addObserver(observer3);

        channel2.addObserver(observer1);

        channel1.addItem(new Item("Все о Kafka", "Ролик о Kafka"));

        channel1.removeObserver(observer2);

    }

}
