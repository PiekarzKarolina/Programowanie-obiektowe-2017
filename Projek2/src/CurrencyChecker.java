/**
 * Klasa sprawdzająca czy wprowadzona nazwa waluty jest poprawna
 * @author Karolina Piekarz
 */
public class CurrencyChecker{

    /**
     * Funkcja sprawdzająca czy nawa waluty podana w argumentach programu na dokładnie 3 znaki oraz czy zawiera tylko litery.
     * @see WrongCurrencyNameException
     * @param currencyName naszwa waluty podana w linii argumentów
     * @throws WrongCurrencyNameException wyjątek gdy nazwa nie spelnia podanych warunków
     */
    public void checkCurrency(String currencyName) throws WrongCurrencyNameException {
        if(currencyName.length() != 3) throw new WrongCurrencyNameException();
        for(int i=0; i<3; i++){
            if(!((currencyName.charAt(i)>'a' && currencyName.charAt(i)<'z') || (currencyName.charAt(i)>'A' && currencyName.charAt(i)<'Z'))) throw new WrongCurrencyNameException();
        }

    }
}
