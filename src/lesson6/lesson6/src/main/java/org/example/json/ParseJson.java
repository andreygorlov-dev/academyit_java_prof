package org.example.json;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ParseJson {

    public static void main(String[] args) throws IOException, ParseException {
        Reader reader = new FileReader("shop.json");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        System.out.println(jsonObject.get("title"));

        JSONArray cars = (JSONArray) jsonObject.get("cars");

        for (Object item : cars) {
            System.out.println(((JSONObject) item).get("name"));
        }

        JSONObject contacts = (JSONObject) jsonObject.get("contact");
        String phone = (String) contacts.get("phone");

        System.out.println(phone);
    }
}
