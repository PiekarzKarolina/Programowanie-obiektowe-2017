
import java.util.Calendar;

/**
 * Klasa sprawdzająca czy podana data jest poprawna
 * @author Karolina Piekarz
 */
public class DateChecker {

    /**
     * Funkcja sprawdzająca poprawność daty. Ze względu na zróżnicowanie pomiędzy dopuszczalną datą dla ceny złota, a datą dla walut potrzebne jest te rozróżnienie typu danych. Dla dat związanych ze złotem jest to string "Gold", dla walut dowolny inny.
     *
     * @param date data do sprawdzenia
     * @param type typ daty (sprawdzna dla złota czy dla waluty)
     * @throws WrongDateFormatException wyjątek, gy podana data jest w niepoprawnym formacie lub nie jest w okresie dla którego można sprawdzać dane
     * @see WrongDateFormatException
     */
    public void checkDate(String date, String type) throws WrongDateFormatException {
        if (date.length() < 10 || date.charAt(4) != '-' || date.charAt(7) != '-') throw new WrongDateFormatException();
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            Calendar cal = Calendar.getInstance();
            if (year < 2013 && type.equals("gold")) throw new WrongGoldDateException();
            if (year < 2002) throw new WrongCurrencyDateException();
            if (year > cal.get(Calendar.YEAR)) throw new WrongDateFormatException();
            int month = Integer.parseInt(date.substring(5, 7)) - 1;
            if (month < 0 || month > 11 || (year == cal.get(Calendar.YEAR) && month > cal.get(Calendar.MONTH)))
                throw new WrongDateFormatException();
            int day = Integer.parseInt(date.substring(8, 10));
            if (day < 0 || day > 31) throw new WrongDateFormatException();
            Calendar cal2 = Calendar.getInstance();
            cal2.set(year, month, day);
            if (cal2.after(cal)) throw new WrongDateFormatException();
        } catch (NumberFormatException e) {
            throw new WrongDateFormatException();
        }
    }

    /**
     * Funkcja sprawdzajaca czy dwie daty są podane w dobrej kolejności
     *
     * @param cal1 data początkowwa
     * @param cal2 data końcowa
     */
    public void checkDate(Calendar cal1, Calendar cal2) throws WrongDateFormatException {
        if (!cal1.before(cal2)) throw new WrongDateFormatException();
    }
}
