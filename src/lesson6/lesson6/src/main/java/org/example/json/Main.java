package org.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        Person person = new Person("Иванов", 30, 10.2d);

        StringWriter stringWriter = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(stringWriter, person);

        System.out.println(stringWriter);

        StringReader str = new StringReader("{\"name\":\"Иванов\",\"age\":30,\"salary\":10.2}");

        ObjectMapper objectMapper1 = new ObjectMapper();

        Person person1 = objectMapper1.readValue(str, Person.class);

        System.out.println(person1);

    }
}
