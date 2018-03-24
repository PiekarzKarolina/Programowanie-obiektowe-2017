import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.util.Calendar;

/**
 * Klasa zajmujaca się wyliczeniem największej i najmniejszej wartości dla danej waluty.
 * @author Karolina Piekarz
 */
public class CurrencyPeak {

    /**
     * funkcja wyliczająca największą i najmniejszą wartość dla danej waluty. Zwraca DoubleDate które przechowuje dwie daty oraz odpowiadające im wartości najwyższą oraz najniższą.
     * @see DocMaker
     * @see DoubleDate
     * @see Document
     * @see Calendar
     * @see Element
     * @see Node
     * @param docMaker klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @param tag1 nazwa etykiety pod którą można znaleźć elementy
     * @param tag2 nazwa etykiety pod którą można znaleźć wartości elementów
     * @param tag3 nazwa etykiety pod którą można znaleźć daty
     * @return Zwraca DouleDate, które zawiera daty najwyższej i najniższej awrości wraz z przyporządkowanymi im liczbami.
     * @throws Exception funkcja wyrzuca wyjątek jeżeli nie uda sie sparsować dokumentu
     */
    public DoubleDate compute(DocMaker docMaker, String tag1, String tag2, String tag3) throws Exception {
        Document document;
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2002, Calendar.JANUARY, 02);
        Calendar cal2 = Calendar.getInstance();

        String MostExpensive = null;
        String Cheapest = null;
        Node root;
        Element eElement;
        Double mostExpensive = null;
        Double cheapest = null;
        cal1.add(Calendar.DATE, 91);

        while(cal1.getTime().before(cal2.getTime())){
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(cal1.getTime());
            cal1.add(Calendar.DATE, -91);
            try {
                document = docMaker.getDoc(cal1, cal3);
                root = document.getDocumentElement();
                eElement = (Element) root;
                for (int i = 0; i < eElement.getElementsByTagName(tag1).getLength(); i++) {
                        Double price = Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent());
                        if (mostExpensive == null) {
                            mostExpensive = price;
                            cheapest = price;
                        } else if (price > mostExpensive) {
                            mostExpensive = price;
                            MostExpensive = eElement.getElementsByTagName(tag3).item(i).getTextContent();
                        } else if (price < cheapest) {
                            cheapest = price;
                            Cheapest = eElement.getElementsByTagName(tag3).item(i).getTextContent();;
                        }
                    }
            }
            catch(FileNotFoundException e){

            }
            //System.out.println(sum);
            finally {
                //Thread.sleep(100);
                cal1.add(Calendar.DATE, 183);
            }
        }
        cal1.add(Calendar.DATE, -91);
        if(cal1.getTime().before(cal2.getTime())){
            try {
                document = docMaker.getDoc(cal1,cal2);
                root = document.getDocumentElement();
                eElement = (Element) root;
                for (int i = 0; i < eElement.getElementsByTagName(tag1).getLength(); i++) {
                        Double price = Double.parseDouble(eElement.getElementsByTagName(tag2).item(i).getTextContent());
                        if (mostExpensive == null) {
                            mostExpensive = price;
                            cheapest = price;
                        } else if (price > mostExpensive) {
                            mostExpensive = price;
                            MostExpensive = eElement.getElementsByTagName(tag3).item(i).getTextContent();
                        } else if (price < cheapest) {
                            cheapest = price;
                            Cheapest = eElement.getElementsByTagName(tag3).item(i).getTextContent();
                        }
                }
            }
            catch(FileNotFoundException e){

            }
        }


        DoubleDate doubleD = new DoubleDate(MostExpensive, Cheapest, cheapest, mostExpensive);
        return  doubleD;
    }
}
