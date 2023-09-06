package lesson2.abstract_factory;

public class Drink {

    private String title;

    public Drink(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Drink setTitle(String title) {
        this.title = title;
        return this;
    }
}
