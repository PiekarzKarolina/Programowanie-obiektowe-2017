import org.w3c.dom.*;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Klasa odpowiedzialna za sparsowanie dokumentu
 * @author Karolina Piekarz
 */
public class Parser {

    /**
     * Funkcja prasująca.
     * @see DocumentBuilder
     * @see DocumentBuilderFactory
     * @see Document
     * @param name nazawa dokumentu do zparsowania (link)
     * @return zwraca sparsowany dokument
     * @throws Exception Jeżeli nie można otworzyć pliku to rzucany jest między innymi wyjątek FileNotFoundException
     */
    public Document parse(String name) throws Exception{
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
             doc = db.parse(name);
        }
        catch (SAXParseException e){
            System.out.println("Couldn't download data. Trying once more...");
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(name);
            }
            catch (SAXParseException ee){
                System.out.println("Couldn't download data. Trying once more...");
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    doc = db.parse(name);
                }
                catch (SAXParseException eee){
                    System.out.println("Couldn't download data.");
                    eee.printStackTrace();
                }
            }
        }
        return doc;
    }
}
