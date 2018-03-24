/**
 * Kalsa przechowująca dwie liczby highest oraz lowest.
 * @author Karolina Piekarz
 */
public class HighestLowest {

    /**
     * Liczba pierwsza
     */
    private Double Highest;

    /**
     * Liczba druga
     */
    private Double Lowest;

    /**
     * @return zwraca liczbę drugą
     */
    public Double getLowest() {
        return Lowest;
    }

    /**
     * @param lowest lizba druga
     */
    public void setLowest(Double lowest) {
        Lowest = lowest;
    }

    /**
     * @return zwraca liczbę pierwszą
     */
    public Double getHighest() { return Highest; }

    /**
     * @param highest liczba pierwsza
     */
    public void setHighest(Double highest) {
        Highest = highest;
    }
}
