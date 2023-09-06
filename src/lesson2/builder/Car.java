package lesson2.builder;

public class Car {

    private final Body body;
    private final Engine engine;
    private final Wheels wheels;
    private final String title;
    private boolean isEngine = false;

    public Car(Body body, Engine engine, Wheels wheels, String title) {
        this.body = body;
        this.engine = engine;
        this.wheels = wheels;
        this.title = title;
    }

    public Body getBody() {
        return body;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public String getTitle() {
        return title;
    }

    public void startEngine() {
        if (!isEngine) {
            engine.on();
            isEngine = true;
        }
    }

    public void stopEngine() {
        if (isEngine) {
            engine.off();
            isEngine = false;
        }
    }

    @Override
    public String toString() {
        return "ICar{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + wheels +
                ", title='" + title + '\'' +
                ", isEngine=" + isEngine +
                '}';
    }

    public static class Builder {
        private String title;
        private Body body;
        private Engine engine;
        private Wheels wheels;

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(Body.Color color, Body.Type type) {
            this.body = new Body(color, type);
            return this;
        }

        public Builder setEngine(int power, int volume) {
            this.engine = new Engine(power, volume);
            return this;
        }

        public Builder setWheels(Wheels.Type type, boolean isLowProfile) {
            this.wheels = new Wheels(type, isLowProfile);
            return this;
        }

        private Body getDefaultBody() {
            return new Body(Body.Color.WHITE, Body.Type.HATCHBACK);
        }

        private Engine getDefaultEngine() {
            return new Engine(250, 20);
        }

        private Wheels getDefaultWheels() {
            return new Wheels(Wheels.Type.SUMMER, false);
        }

        public Car build() {
            if (title == null) {
                title = "Базовый автомобиль";
            }

            if (body == null) {
                body = getDefaultBody();
            }

            if (engine == null) {
                engine = getDefaultEngine();
            }

            if (wheels == null) {
                wheels = getDefaultWheels();
            }

            return new Car(body, engine, wheels, title);
        }
    }
}
