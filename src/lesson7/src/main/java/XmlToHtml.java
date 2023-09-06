import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlToHtml {

    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();

        Source source = new StreamSource(new File("test.xsl"));

        Transformer transformer = factory.newTransformer(source);

        transformer.transform(new StreamSource(new File("shop.xml")), new StreamResult(new File("output.html")));

    }

}
