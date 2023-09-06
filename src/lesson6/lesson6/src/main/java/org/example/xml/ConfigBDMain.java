package org.example.xml;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigBDMain {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        Map<String, String> configMap = new HashMap<>();
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression xPathExpression = xPath.compile("/config/attr");
        Object result = xPathExpression.evaluate(new InputSource(new FileReader("config.xml")), XPathConstants.NODESET);
        NodeList nodeList = (NodeList) result;

        for (int i =0; i < nodeList.getLength(); i++) {
            configMap.put(nodeList.item(i).getAttributes().item(0).getTextContent(), nodeList.item(i).getTextContent());
        }

        for (Map.Entry<String, String> item : configMap.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

}
