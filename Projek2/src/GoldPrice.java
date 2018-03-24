
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Calendar;

/**
 * Klasa pozwalająca sprawdzić cenę złota w danym dniu
 * @author Karolina Piekarz
 */
public class GoldPrice {

    /**
     * Funkcja zwracająca cenę złota dla danej daty podanej w kalendarzu
     * @param cal data zawarta w kalendarzu
     * @param tag nazwa etykiety pod którą można znaleźć element
     * @return cena złota dla podanej daty
     * @throws Exception Jeżeli nie ma danych na dany dzień rzucany jest między innymi wyjątek FileNotFoundException, który informuje o braku danych w danym dniu
     */
    public double getgoldPrice(Calendar cal, String tag) throws Exception{
        GoldRecord gold = new GoldRecord();
        Document doc = gold.getDoc(cal);

        Node root = doc.getDocumentElement();

        Element eElement = (Element) root;
        Double price = Double.parseDouble(eElement.getElementsByTagName(tag).item(0).getTextContent());

        return price;

    }
}
