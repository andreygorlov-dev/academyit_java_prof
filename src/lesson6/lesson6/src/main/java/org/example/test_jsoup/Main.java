package org.example.test_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("http://fmredmine.krista.ru/issues/174630").get();

        System.out.println(document.title());


        List<Element> elements = document.select("img");

        int i = 0;
        for (Element item : elements) {
            String path = item.absUrl("src");
            if (!path.isEmpty()) {
                BufferedImage img = ImageIO.read(new URL(path));
                ImageIO.write(img, "png", new File("C:\\Sources\\academyit_java_prof\\src\\lesson6\\lesson6\\src\\main\\resources".concat(String.valueOf(i)).concat(".png")));
                i++;
            }
        }
    }



}
