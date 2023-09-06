package lesson2.builderhouse;

import jdk.nashorn.internal.ir.SplitReturn;

public class House {

    private boolean isSwimmingPool;
    private boolean isGarage;
    public enum Type {
        COTTAGE,
        PENTHOUSE
    }

    private Type type;

    private Double square;

    private boolean isFencing;
    private Window window;

    public House(boolean isSwimmingPool, boolean isGarage, Type type, Double square, boolean isFencing, Window window) {
        this.isSwimmingPool = isSwimmingPool;
        this.isGarage = isGarage;
        this.type = type;
        this.square = square;
        this.isFencing = isFencing;
        this.window = window;
    }

    @Override
    public String toString() {
        return "House{" +
                "isSwimmingPool=" + isSwimmingPool +
                ", isGarage=" + isGarage +
                ", type=" + type.name() +
                ", square=" + square +
                ", isFencing=" + isFencing +
                ", window=" + window +
                '}';
    }

    public static class Builder {

        private boolean isSwimmingPool = false;
        private boolean isGarage = true;

        private Type type;

        private Double square = 24.4d;

        private boolean isFencing = true;

        private Window window;

        public static Builder newInstance() {
            return  new Builder();
        }

        public Builder setSwimmingPool(boolean swimmingPool) {
            isSwimmingPool = swimmingPool;
            return this;
        }

        public Builder setGarage(boolean garage) {
            isGarage = garage;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setSquare(Double square) {
            this.square = square;
            return this;
        }

        public Builder setFencing(boolean fencing) {
            isFencing = fencing;
            return this;
        }

        public Builder setWindow(int countSection, Window.Type type) {
            this.window = new Window(countSection, type);
            return this;
        }

        public House build() {
            if (type == null) {
                type = Type.PENTHOUSE;
            }

            if (window == null) {
                window = new Window(3, Window.Type.PLASTIC );
            }

            return new House(isSwimmingPool, isGarage, type, square, isFencing, window);
        }

    }
}

