import org.w3c.dom.Document;

import java.io.FileNotFoundException;
import java.util.Calendar;

/**
 * Abstrakcyjna klasa umożliwiwjąca stworzenie dokumentu an podstawie linku
 * @author Karolina Piekarz
 */
public abstract class DocMaker {
    /**
     * Prywatna zmienna link przechowująca link z którego mają zostać odczytane dane
     */
    protected String link;

    /**
     * abstrakcyjna metoda inicjalizująca zmienna link danym ciągiem znaków
     */
    abstract void getLink();

    /**
     * parser uzywany do przetworzenia danych na dokument
     * @see Parser
     */
    private Parser parser = new Parser();

    /**
     * obiekt umożliwiający formatownaie daty
     * @see DateFormater
     */
    DateFormater formater = new DateFormater();

    /**
     * funkcja tworząca dokument na podstawie jednej daty
     * @see Document
     * @see Calendar
     * @param cal klaendarz zawierający datę na podstawie ktorej tworznoy jest link
     * @return sparsowany dokument
     * @throws Exception wyjątek jeżeli stworzenie dokumentu się nie powiedzie
     */
    public Document getDoc(Calendar cal) throws Exception{
        this.getLink();
        link+= formater.format(cal);
        link += "/?format=xml";
        //System.out.println(link);
        Document doc = parser.parse(link);

        return doc;
    }

    /**
     * funkcja tworząca dokument na podstawie dówch dat - zakresu danych
     * @param startDate kalendarz zawierający datę początkową
     * @param endDate kaledarz zawierający datę końcową
     * @see Calendar
     * @see Document
     * @return sparsowany dokument
     * @throws Exception wyjątek jeżeli stworzenie dokumentu się nie powiedzie
     */
    public Document getDoc(Calendar startDate, Calendar endDate) throws Exception{
        this.getLink();
        link += formater.format(startDate);
        link += "/";
        link += formater.format(endDate);
        link += "/?format=xml";
        //System.out.println(link);
        Document doc = parser.parse(link);
        return doc;
    }
}

