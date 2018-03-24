/**
 * Klasa rozszerzająca klasę DocMaker. Implemntuje metodę getLink():void, która pozwala ustawić link z którego pobierane będą dane dotyczące danej waluty.
 * @see DocMaker
 * @author Karolina Piekarz
 */
public class Currency extends DocMaker {

    /**
     * Nazwa waluty o której pobierane mają być dane.
     */
    private String name;

    /**
     * @return zwraca nazwę waluty
     */
    public String getName() {
        return name;
    }

    /**
     * @param name nazwa waluty
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Konstruktor, tworzy obiekt klasy Currency.
     * @param name nazwa waluty
     */
    public Currency(String name) {
        super();
        this.name = name;
    }

    /**
     * Funkcja nadpisująca metodę getLink():void. Ustawia ona zmienną link należącą do klasy DocMaker na odpowiednią wartość.
     */
    @Override
    void getLink() {
        link = "http://api.nbp.pl/api/exchangerates/rates/a/"+name+"/";
    }

}
