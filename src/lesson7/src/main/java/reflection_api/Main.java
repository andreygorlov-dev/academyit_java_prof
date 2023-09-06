package reflection_api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();

        Field[] fields = Person.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
        }

        fields[0].set(person, 25);
        fields[1].set(person, "Иванов");

        runPrivateMethod(person, "showInfo");
    }

    private static void runPrivateMethod(Person person, String titleMethod) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = person.getClass().getDeclaredMethod(titleMethod);
        method.setAccessible(true);
        method.invoke(person);
    }

}
