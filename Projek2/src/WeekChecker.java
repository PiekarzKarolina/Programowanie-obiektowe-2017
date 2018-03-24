/**
 * Klasa sprawdzająca czy podany numer tygodnia jest poprawny
 * @see  WrongWeekException
 * @author Karolina Piekarz
 */
public class WeekChecker {
    /**
     * Funkcja sprawdzająca poprawność numeru tygodnia
     * @param number numer tygodnia w miesiącu
     * @throws WrongWeekException  wyjątek, gdy podany dzień tygodnia jest niepoprawny
     */
    public void checkWeek(int number) throws WrongWeekException{
        if(number<-1 || number>5) throw new WrongWeekException();
    }
}
