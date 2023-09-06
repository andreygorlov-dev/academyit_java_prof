package lesson3.strategy;

public class Parser {

    public void showResult(String path) {
        ParseDoc parseDoc = null;
        String[] mas = path.split("\\.");
        String str = mas[mas.length - 1];

        if (str.equalsIgnoreCase("xml")) {
            parseDoc = new ParseXml();
        } else if (str.equalsIgnoreCase("json")) {
            parseDoc = new ParseJson();
        }

        parseDoc.parse(path);

    }

    public static void main(String[] args) {
        new Parser().showResult("test.xml");
    }

}