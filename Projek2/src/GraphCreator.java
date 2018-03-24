import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Klasa zajmująca się rysowaniem wykresu cen z podzialem na dni tygodnia.
 * @author Karolina Piekarz
 */
public class GraphCreator {
    ArrayList<String> graph = new ArrayList<>();

    /**
     * Funkcja która rysuje wykres dla podanych ram czasowych
     * @see DocMaker
     * @see Calendar
     * @see Node
     * @see Element
     * @see DateFormater
     * @see Document
     * @param cal1 data początkowa
     * @param cal2 data końcowa
     * @param docMaker  klasa posiadajaca metodę która pozwala na stworzenie dokumentu
     * @param tag1 nazwa etykiety pod którą można znaleźć elementy
     * @param tag2 nazwa etykiety pod którą można znaleźć wartości elementów
     * @param tag3 nazwa etykiety pod którą można znaleźć daty
     * @throws Exception funkcja wyrzuca wyjątek jeżeli nie uda sie sparsować dokumentu
     */
    public void create(Calendar cal1, Calendar cal2, DocMaker docMaker, String tag1, String tag2, String tag3) throws Exception{
        cal1.add(Calendar.DATE, 91);
        Document document;
        Node root;
        Element eElement;
        DateFormater formater = new DateFormater();
        int DayOfWeek = 2;

        while(cal1.getTime().before(cal2.getTime())){
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(cal1.getTime());
            cal1.add(Calendar.DATE, -91);
            try {
                document = docMaker.getDoc(cal1, cal3);
                root = document.getDocumentElement();
                eElement = (Element) root;
                for (int i = 0; i < eElement.getElementsByTagName(tag1).getLength(); i++) {
                    Calendar cal = formater.format(eElement.getElementsByTagName(tag3).item(i).getTextContent());
                    if(cal.get(Calendar.DAY_OF_WEEK)==7 || cal.get(Calendar.DAY_OF_WEEK)==1){

                    }
                    else if(DayOfWeek == cal.get(Calendar.DAY_OF_WEEK)){
                        if(DayOfWeek==6) DayOfWeek=2;
                        else DayOfWeek++;
                        graph.add(eElement.getElementsByTagName(tag2).item(i).getTextContent());
                    }
                    else{
                        graph.add("Ala");
                    }
                }
            }
            catch(FileNotFoundException e){

            }
            //System.out.println(sum);
            finally {
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
                    Calendar cal = formater.format(eElement.getElementsByTagName(tag3).item(i).getTextContent());
                    //System.out.println(DayOfWeek + " " + cal.get(Calendar.DAY_OF_WEEK));
                    if(cal.get(Calendar.DAY_OF_WEEK)==1 || cal.get(Calendar.DAY_OF_WEEK)==7){

                    }
                    else if(DayOfWeek == cal.get(Calendar.DAY_OF_WEEK)){
                        if(DayOfWeek==6) DayOfWeek=2;
                        else DayOfWeek++;
                        graph.add(eElement.getElementsByTagName(tag2).item(i).getTextContent());
                    }
                    else{
                        graph.add("Ala");
                        if(DayOfWeek==6) DayOfWeek=2;
                        else DayOfWeek++;
                        i--;
                    }
                }
            }
            catch(FileNotFoundException e){

            }
        }

        if(graph.size()==0){
            throw new NonExistentCurrencyException();
        }
        else {
            Double max = Double.parseDouble(graph.get(0));
            Double min = Double.parseDouble(graph.get(0));
            for (int j = 1; j < graph.size(); j++) {
                if (!graph.get(j).equals("Ala")) {
                    Double mid = Double.parseDouble(graph.get(j));
                    if (mid > max) max = mid;
                    else if (mid < min) min = mid;
                }
            }

            Double step = (max - min) / 50;

            for (int i = 0; i < 5; i++) {
                String dzien;
                switch (i) {
                    case 0:
                        dzien = "Pon";
                        break;
                    case 1:
                        dzien = "Wt";
                        break;
                    case 2:
                        dzien = "Sr";
                        break;
                    case 3:
                        dzien = "Czw";
                        break;
                    case 4:
                        dzien = "Pt";
                        break;
                    default:
                        dzien = "Sobota";
                }
                for (int j = i; j < graph.size(); j += 5) {
                    int tydzien = (j - i) / 5 + 1;
                    System.out.print(dzien + tydzien + ": ");
                    if (!graph.get(j).equals("Ala")) {
                        Double mid = Double.parseDouble(graph.get(j));
                        System.out.print("*");
                        for (Double k = min; k < mid; k += step) {
                            System.out.print("*");
                        }
                        System.out.print(" " + graph.get(j) + "\n");
                    } else {
                        System.out.print("No data\n");
                    }
                }
            }
        }
    }
}
