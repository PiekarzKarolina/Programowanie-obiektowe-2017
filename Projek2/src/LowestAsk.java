import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Calendar;

/**
 * Klasa pozwalająca sprawdzić dla jakiej waluty kurs kupna był najniższy w danym dniu.
 * @author Karolina Piekarz
 */
public class LowestAsk {

    /**
     * Funkcja oblicza która waluta w danym dniu miała najniższą cenę kupna
     * @see Calendar
     * @see DocMaker
     * @param cal kalendarz przechowywujący datę dla której odczytywane są wyniki
     * @param docMaker klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @param tag1 nazwa etykiety pod którą można znaleźć elementy
     * @param tag2 nazwa etykiety pod którą można znaleźć wartości elementów
     * @return nazwa waluty, która w danym dniu miała najmniejszą cenę kupna
     * @throws Exception Jeżeli nie ma danych na dany dzień rzucany jest między innymi wyjątek FileNotFoundException, który informuje o braku danych w danym dniu
     */
    public String findLowestAsk(Calendar cal, DocMaker docMaker, String tag1, String tag2) throws Exception{
        Document document = docMaker.getDoc(cal);

        Node root = document.getDocumentElement();
        Element eElement = (Element) root;

        Double lowestAsk = Double.parseDouble(eElement.getElementsByTagName(tag2).item(0).getTextContent());
        String currencyName = eElement.getElementsByTagName(tag1).item(0).getTextContent();

        for(int i = 1; i<eElement.getElementsByTagName(tag2).getLength(); i++){
            Double ask = Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent());
            if(lowestAsk>ask){
                lowestAsk = ask;
                currencyName = eElement.getElementsByTagName(tag1).item(i).getTextContent();
            }
        }

        return currencyName;
    }
}
