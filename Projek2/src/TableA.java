/**
 * Klasa rozszerzająca klasę DocMaker. Implemntuje metodę getLink():void, która pozwala ustawić link z którego pobierane będą dane dotyczące danej waluty.
 * @see DocMaker
 * @author Karolina Piekarz
 */
public class TableA extends DocMaker{

    /**
     * Funkcja nadpisująca metodę getLink():void. Ustawia ona zmienną link należącą do klasy DocMaker na odpowiednią wartość.
     */
    @Override
    void getLink() {
        link = "http://api.nbp.pl/api/exchangerates/tables/a/";
    }
}
