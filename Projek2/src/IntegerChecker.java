/**
 * Klasa sprawdzająca czy podana liczba jest poprawna
 * @author Karolina Piekarz
 */
public class IntegerChecker {

    /**
     * Funkcja sprawdzająca poprawność wpisanego numeru
     * @see WrongIntegerException
     * @param integer ciąg znaków do sprawdzenia
     * @throws WrongIntegerException wyjątek, gdy podany ciąg znaków nie zawiera tylko cyfr
     */
    public void checkInteger(String integer) throws WrongIntegerException {
        for(int i=0; i<integer.length(); i++){
            if(!(integer.charAt(i)>'0' && integer.charAt(i)<'9')) throw new WrongIntegerException();
        }
    }
}
