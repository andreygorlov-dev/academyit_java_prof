package lesson2.observer;

public class Item {

    private String title;
    private String content;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Item setContent(String content) {
        this.content = content;
        return this;
    }
}
