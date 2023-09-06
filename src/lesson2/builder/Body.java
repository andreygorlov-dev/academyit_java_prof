package lesson2.builder;

public class Body {

    public enum Color {
        BLACK,
        WHITE,
        SILVER,
        RED
    }

    public enum Type {
        SEDAN,
        HATCHBACK,
        LIFTBACK
    }

    private final Color color;
    private final Type type;

    public Body(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Body{" +
                "color=" + color.name() +
                ", type=" + type.name() +
                '}';
    }
}
