package org.example.xml;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParserXPath {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression xPathExpression = xPath.compile("/books/book[id = 2]/authors/author/text()");
        Object result = xPathExpression.evaluate(new InputSource(new FileReader("book.xml")), XPathConstants.NODESET);
        NodeList nodeList = (NodeList) result;
        for (int i =0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }
}
