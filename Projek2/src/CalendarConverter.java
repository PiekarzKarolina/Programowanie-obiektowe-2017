import java.util.Calendar;

/**
 * Klasa zamieniająca datę wyrazoną poprzez rok, miesiąc oraz tydzień miesiąca na datę w kalendarzu.
 * @author Karolina Piekarz
 */
public class CalendarConverter {

    /**
     * Funkcja zamieniająca datę z początkowego okresu. Jako dzień brany jest pod uwagę poniedziałek danego tygodnia.
     * @param year rok
     * @param month miesiąc
     * @param number numer tygodnia w miesiącu
     * @return Funkcja zwraca kalendarz z podaną w argumentach datą.
     */
    public Calendar convertFirst(int year, int month, int number){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month,1+(number-1)*7);
        while(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY){
            cal.add(Calendar.DATE, 1);
        }
        return cal;
    }

    /**
     * Funkcja zamieniająca datę z końcowego okresu. Jako dzień brany jest pod uwagę piątek danego tygodnia.
     * @param year rok
     * @param month miesiąc
     * @param number numer tygodnia w miesiącu
     * @return Funkcja zwraca kalendarz z podaną w argumentach datą.
     */
    public Calendar convertLast(int year, int month, int number){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month,1+(number-1)*7);
        while(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.FRIDAY){
            cal.add(Calendar.DATE, 1);
        }
        return cal;
    }

}
