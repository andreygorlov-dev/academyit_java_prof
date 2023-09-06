package lesson2.builderhouse;

public class Window {

    private int countSection;

    public enum Type {
        PLASTIC,
        WOOD
    }

    private Type type;

    public Window(int countSection, Type type) {
        this.countSection = countSection;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Window{" +
                "countSection=" + countSection +
                ", type=" + type.name() +
                '}';
    }
}
