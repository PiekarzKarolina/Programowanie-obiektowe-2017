import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Klasa zajmująca się wypisaniem N posortowanych walut w danym dniu
 * @author Karolina Piekarz
 */
public class PrinterNSorted {

    /**
     *  Lista nazw walut oraz róznic pomiędzy ceną kupna a sprzedaży w danym dniu
     */
    ArrayList<AskBidDifference> amplitudes = new ArrayList<>();

    /**
     * funkcja wypisujaca na ekran N posrtowanych (pod względem różnicy między kupnem a sprzedażą) walut w danym dniu
     * @see AskBidDifference
     * @see DocMaker
     * @see Document
     * @see Node
     * @see Element
     * @param n liczba wyników do wyświetlenia
     * @param docMaker klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @param cal alendarz przechowywujący datę dla której odczytywana jest cena
     * @throws Exception Jeżeli nie ma danych na dany dzień rzucany jest między innymi wyjątek FileNotFoundException, który informuje o braku danych w danym dniu
     */
    public void printNSorted(int n, DocMaker docMaker, Calendar cal) throws Exception{
        Document document = docMaker.getDoc(cal);

        Node root = document.getDocumentElement();
        Element eElement = (Element) root;

        for(int i = 0; i<eElement.getElementsByTagName("Currency").getLength(); i++){
           Double Ask = Double.parseDouble(eElement.getElementsByTagName("Ask").item(i).getTextContent());
           Double Bid = Double.parseDouble(eElement.getElementsByTagName("Bid").item(i).getTextContent());
           Double Amplitude = Math.abs(Ask - Bid);
           Amplitude = Math.round(Amplitude * 10000D) / 10000D;
           AskBidDifference diference = new AskBidDifference(eElement.getElementsByTagName("Currency").item(i).getTextContent(), Amplitude);
           amplitudes.add(diference);
        }

        Collections.sort(amplitudes, new AmplitudeComparator());

        for(int i=0; i<n; i++){
            if(i<amplitudes.size()){
                System.out.println("Currency: " + amplitudes.get(i).getCurrencyName() + ", amplitude: " + amplitudes.get(i).getAmplitude() );
            }
            else{
                break;
            }
        }


    }
}
