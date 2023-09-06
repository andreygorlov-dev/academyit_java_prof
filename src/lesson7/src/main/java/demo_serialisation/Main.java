package demo_serialisation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Person person = new Person("Иванов", "Иванов", 1);

        try (FileOutputStream fileOutputStream = new FileOutputStream("testSer.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(person);
        }
    }
}
