import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Klasa umożliwiająca wyszukanie największej i najmniejszej warości z pola tag2 dla każdej waluty począwszy od danego dnia oraz wyszukanie waluty której kurs uległ największym wahaniom.
 * @author Karolina Piekarz
 */
public class HighestAmplitudeFinder {

    /**
     * HashMapa walut jakie występują w dokumencie oraz odpowiadających im najwyższych i najniższych wartości.
     * @see HashMap
     */
    HashMap<String, HighestLowest> currencies = new HashMap<>();

    /**
     * @return HashMapa walut z ich największymi i najmnijeszymi wartościami
     */
    public HashMap<String, HighestLowest> getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies HashMapa walut z ich największymi i najmnijeszymi wartościami
     */
    public void setCurrencies(HashMap<String, HighestLowest> currencies) {
        this.currencies = currencies;
    }

    /**
     * Funkcja wstawia lub podmienia wartości w tablicy currencies
     * @see HighestLowest
     * @see Document
     * @see Element
     * @see Node
     * @param doc przetwarzany dokument
     * @param tag1 nazwa etykiety pod którą można znaleźć elementy
     * @param tag2 nazwa etykiety pod którą można znaleźć wartości
     */
    private void getHighestLowest(Document doc, String tag1, String tag2){
        Node root = doc.getDocumentElement();
        Element eElement = (Element) root;
        for(int i = 0; i<eElement.getElementsByTagName(tag1).getLength(); i++){
            if(!currencies.containsKey(eElement.getElementsByTagName(tag1).item(i).getTextContent())){
                //System.out.println(eElement.getElementsByTagName("Currency").item(i).getTextContent());
                HighestLowest mid = new HighestLowest();
                mid.setHighest(Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent()));
                mid.setLowest(Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent()));
                currencies.put(eElement.getElementsByTagName(tag1).item(i).getTextContent(), mid);
            }
            else{
                HighestLowest mid = currencies.get(eElement.getElementsByTagName(tag1).item(i).getTextContent());
                Double mid2 = Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent());
                if(mid.getHighest()<mid2){
                    mid.setHighest(mid2);
                    currencies.remove(eElement.getElementsByTagName(tag1).item(i).getTextContent());
                    currencies.put(eElement.getElementsByTagName(tag1).item(i).getTextContent(), mid);
                }
                else if(mid.getLowest()>mid2){
                    mid.setLowest(mid2);
                    currencies.remove(eElement.getElementsByTagName(tag1).item(i).getTextContent());
                    currencies.put(eElement.getElementsByTagName(tag1).item(i).getTextContent(), mid);
                }
            }
        }
    }

    /**
     * Funkcja wyszukuje walutę której kurs w danym okresie uległ największym wahaniom.
     * @see Calendar
     * @see Document
     * @param cal1 kalendar zawierający date od której zaczynane jest szukanie
     * @param docMaker klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @return nazwa waluty dla której apmlituda w danym okresie była największa
     * @throws Exception
     */
    public String getHighestAmplitudeCurrency(Calendar cal1, DocMaker docMaker, String tag1, String tag2) throws Exception{
        Calendar cal2 = Calendar.getInstance();
        Document document;
        while(cal1.getTime().before(cal2.getTime())){
            try {
                document = docMaker.getDoc(cal1);
                this.getHighestLowest(document, tag1, tag2);
            }
            catch (FileNotFoundException e){

            }
            finally {
                cal1.add(Calendar.DATE, 1);
            }
        }

        Double highestAmplitude = 0.0;
        String currencyName = null;

        for(String currencyName2 : currencies.keySet()){
           Double amplitude =  currencies.get(currencyName2).getHighest() - currencies.get(currencyName2).getLowest();
           //System.out.println(currencyName2);
           if(amplitude>highestAmplitude){
               highestAmplitude = amplitude;
               currencyName = currencyName2;
           }
        }
        return currencyName;
    }
}
