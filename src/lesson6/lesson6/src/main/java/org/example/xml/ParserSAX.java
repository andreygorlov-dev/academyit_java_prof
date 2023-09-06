package org.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParserSAX extends DefaultHandler {

    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("book.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(file, new ParserSAX());

        System.out.println(builder);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        builder.append("Элемент ")
                .append(qName)
                .append(" открыт\n");

        if (attributes.getLength() != 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                builder.append("Атрибут ")
                        .append(attributes.getQName(i))
                        .append(" value = ")
                        .append(attributes.getValue(i))
                        .append("\n");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        builder.append("Тэг ")
                .append(qName)
                .append(" закрыт\n");
    }
}
