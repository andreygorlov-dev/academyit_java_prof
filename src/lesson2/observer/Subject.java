package lesson2.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String title;
    private List<Item> itemList;
    private List<Observer> observers;

    public Subject(String title, List<Item> itemList) {
        this.title = title;
        this.itemList = itemList;
        observers = new ArrayList<>();
    }

    public void showItems() {
        for (Item item : itemList) {
            System.out.println(item.getTitle() + " " + item.getContent());
        }
    }

    public void addObserver(Observer observer) {
        observer.addChannel(this.title);
        observers.add(observer);
        System.out.println(observers);
    }

    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Пользователь удален " + observer.getLogin());
        }
        System.out.println(observers);
    }

    public void addItem(Item item) {
        itemList.add(item);

        notifyAll(item);
    }

    public void notifyAll(Item item) {
        for (Observer observer : observers) {
            observer.notify("Уважаемый " + observer.getLogin() + " на канале " + title + " добавлен ролик " + item.getTitle());
        }
    }

}
