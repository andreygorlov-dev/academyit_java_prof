package lesson2.builder;

public class Wheels {

    enum Type {
        WINTER,
        SUMMER
    }

    private final Type type;
    private final boolean isLowProfile;

    public Wheels(Type type, boolean isLowProfile) {
        this.type = type;
        this.isLowProfile = isLowProfile;
    }

    public Type getType() {
        return type;
    }

    public boolean isLowProfile() {
        return isLowProfile;
    }

    @Override
    public String toString() {
        return "Wheels{" +
                "type=" + type.name() +
                ", profile=" + (isLowProfile ? "log" : "standart") +
                '}';
    }
}
