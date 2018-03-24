import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.util.Calendar;

/**
 * Klasa pozwalająca obliczyć średnią w danym okresie.
 * @author Karolina Piekarz
 */
public class AverageCalculator {

    /**
     * Prywatna funkcja obliczająca sumę dla danego zestawu danych. Modfikuje ona zmienną days służacą do policzenia ilości dni dla których wykonywana jest suma.
     * @see Days
     * @see Document
     * @see Element
     * @see Node
     * @param doc dokument do przetworzenia
     * @param days zmienna przechowująca ilość dni po których funkcja sumuje
     * @param tag nazwa etykiety pod którą można znaleźć zmienną do sumowania
     * @return Funkcja zwraca sumę elementów o danym tagu w dokumencie.
     */
    private Double computeSum(Document doc, Days days, String tag){
        Node root = doc.getDocumentElement();

        Double sum = 0.0;
        Double days2 = 0.0;

        Element eElement = (Element) root;
        for(int i = 0; i<eElement.getElementsByTagName(tag).getLength(); i++){
            sum+=Double.parseDouble(eElement.getElementsByTagName(tag).item(i).getTextContent());
            days2++;
        }
        days.add(days2);
        return sum;
    }

    /**
     * Funkcja obliczająca średnią dla danego zestawu danych.
     * @see Calendar
     * @see DocMaker
     * @param cal1 data od której zaczęte jest liczenie średniej
     * @param cal2 data na której skończone jest liczenie średniej
     * @param docMaker klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @param tag nazwa etykiety pod którą można znaleźć zmienną do sumowania
     * @return Funkcja zwraca średnią wartość elementu pod etykietą tag w okresie od daty z cal1 do daty z cal2.
     * @throws Exception funkcja wyrzuca wyjątek jeżeli nie uda sie sparsować dokumentu
     */
    public Double computeAverage(Calendar cal1, Calendar cal2, DocMaker docMaker, String tag) throws Exception{
        Double sum = 0.0;
        Days days = new Days();
        days.setDays(0.0);
        Document document;
        cal1.add(Calendar.DATE, 91);
        while(cal1.getTime().before(cal2.getTime())){
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(cal1.getTime());
            cal1.add(Calendar.DATE, -91);
            try {
                document = docMaker.getDoc(cal1, cal3);
                sum += this.computeSum(document, days, tag);
            }
            catch(FileNotFoundException e){

            }
            finally {
                cal1.add(Calendar.DATE, 183);
            }
        }
        cal1.add(Calendar.DATE, -91);
        if(cal1.getTime().before(cal2.getTime())){
            try {
                document = docMaker.getDoc(cal1, cal2);
                sum+=this.computeSum(document, days, tag);
            }
            catch(FileNotFoundException e){

            }
        }
        Double Average = sum/days.getDays();
        Average = Math.round(Average * 100D) / 100D;
        return Average;

    }
}
