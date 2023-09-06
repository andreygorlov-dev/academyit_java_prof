package lesson2.abstract_factory;

public class Food {

    private String title;

    public Food(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Food setTitle(String title) {
        this.title = title;
        return this;
    }
}
