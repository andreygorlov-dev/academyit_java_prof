package demo_serialisation;

import java.io.*;

public class DeserMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("testSer.ser");

        ObjectInputStream obj = new ObjectInputStream(inputStream);
        Person person = (Person) obj.readObject();
        System.out.printf(person.getName());
    }

}
