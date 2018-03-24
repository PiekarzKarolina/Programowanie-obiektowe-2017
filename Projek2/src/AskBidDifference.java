/**
 * Klasa pomocnicza przechowując wartość różnicy pomiędzy sprzedażą a kupnem dla danej waluty oraz jej nazwę.
 * @author Karolina Piekarz
 */
public class AskBidDifference {
    /**
     *Różnica pomiędzy ceną kupa a ceną sprzedaży dla danej waluty.
     */
    private Double amplitude;
    /**
     * Nazwa waluty.
     */
    private String currencyName;


    /**
     * Konstruktor, tworzy obiekt klasy AskBidDifference.
     * @param currencyName nazwa waluty
     * @param amplitude różnica pomiędzy ceną kupna a sprzedaży
     */
    public AskBidDifference(String currencyName, Double amplitude) {
        this.currencyName = currencyName;
        this.amplitude = amplitude;
    }

    /**
     * @return zwaraca nazwę waluty
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * @param currencyName nazwa waluty
     */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    /**
     * @return zwraca różnice pomiędzy ceną kupna a sprzedaży
     */
    public Double getAmplitude() {

        return amplitude;
    }

    /**
     * @param amplitude różnica między ceną kupna a sprzedaży
     */
    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }
}
