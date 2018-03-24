import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.print.Doc;
import java.util.Calendar;

/**
 * Klasa która umożliwia obliczenie ceny danej waluty na dany dzień
 * @author Karolina Piekarz
 */
public class CurrencyPrice {

    /**
     * Funkcja odczytująca cenę danej waluty dal danego dnia.
     * @see Currency
     * @see Node
     * @see Element
     * @param cal kalendarz przechowywujący datę dla której odczytywana jest cena
     * @param name nazwa waluty dla której ocztytywana jest cena
     * @param tag nazwa etykiety pod którą można znaleźć zmienną która należy odczytać
     * @return Funkcja zwraca cenę danej waluty w danym dniu
     * @throws Exception Jeżeli nie ma danych na dany dzień rzucany jest między innymi wyjątek FileNotFoundException, który informuje o braku danych w danym dniu
     */
    public double getcurrencyPrice(Calendar cal, String name, String tag) throws Exception{
        Currency curr = new Currency(name);
        Document doc = curr.getDoc(cal);

        Node root = doc.getDocumentElement();

        Element eElement = (Element) root;
        Double price = Double.parseDouble(eElement.getElementsByTagName(tag).item(0).getTextContent());

        return price;

    }
}
