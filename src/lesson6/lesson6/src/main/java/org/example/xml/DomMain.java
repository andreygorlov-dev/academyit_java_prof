package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomMain {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        parser("book.xml");
    }

    private static void parser(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(path);
        if (document == null) {
            return;
        }

        showDocument(document);
    }

    private static void showDocument(Node node) {
        switch (node.getNodeType()) {
            case Node.DOCUMENT_NODE:
                System.out.println("<?xml version=\"1.1\" encoding=\"UTF-8\"?>");
                showDocument(((Document) node).getDocumentElement());
                break;
            case Node.ELEMENT_NODE:
                System.out.print("<" + node.getNodeName());
                NamedNodeMap attrs = node.getAttributes();
                if (attrs != null) {
                    for (int i = 0; i < attrs.getLength(); i++) {
                        showDocument(attrs.item(i));
                    }
                }
                System.out.print(">");
                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++) {
                        showDocument(children.item(i));
                    }
                }
                System.out.print("</" + node.getNodeName() + ">");
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.print(" " + node.getNodeName() + "='" + node.getNodeValue() + "'");
                break;
            case Node.TEXT_NODE:
                System.out.print(node.getNodeValue());
                break;
            default:
                break;
        }
    }

}
