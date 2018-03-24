/**
 * Klasa przechowująca dwie daty oraz odpowiadające im wartości.
 * @author Karolina Piekarz
 */
public class DoubleDate {

    /**
     * Data pierwsza
     */
    private String FirstDate;

    /**
     * Data druga
     */
    private String SecondDate;

    /**
     * Wartość najniższa (wartość przechowywana 1)
     */
    private Double lowest;

    /**
     * Wartość najwyższa (wartość przechowywana 2)
     */
    private Double highest;

    /**
     * @return zwraca wartość przechowywaną 2
     */
    public Double getHighest() {
        return highest;
    }

    /**
     * @param highest wartość przechowywana 2
     */
    public void setHighest(Double highest) {
        this.highest = highest;
    }

    /**
     * @return zwraca wartość przechowywaną 1
     */
    public Double getLowest() {

        return lowest;
    }

    /**
     * @param lowest wartość przechowywana 1
     */
    public void setLowest(Double lowest) {
        this.lowest = lowest;
    }

    /**
     * Konstruktor, tworzy obiekt klasy DoubleDate
     * @param firstDate data pierwsza
     * @param secondDate data druga
     * @param lowest wartość przechowywana 1
     * @param highest wartość przechowywana 2
     */
    public DoubleDate(String firstDate, String secondDate, Double lowest, Double highest) {
        this.FirstDate = firstDate;
        this.SecondDate = secondDate;
        this.lowest = lowest;
        this.highest = highest;
    }

    /**
     * @return zwraca datę drugą
     */
    public String getSecondDate() {

        return SecondDate;
    }

    /**
     * @param secondDate data druga
     */
    public void setSecondDate(String secondDate) {
        SecondDate = secondDate;
    }

    /**
     * @return zwraca datę pierwszą
     */
    public String getFirstDate() {

        return FirstDate;
    }

    /**
     * @param firstDate data pierwsza
     */
    public void setFirstDate(String  firstDate) {
        FirstDate = firstDate;
    }
}
