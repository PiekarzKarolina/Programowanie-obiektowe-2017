/**
 * Klasa przechowująca liczbę dni. Metoda w tej klasie umożliwia zwiększenie zmiennej tej klasy o dowolną liczbę.
 * @author Karolina Piekarz
 */
public class Days {
    /**
     * Zmienna przechowująca liczbę dni.
     */
    private Double days;

    /**
     * @return liczba dni
     */
    public Double getDays() {
        return days;
    }

    /**
     * @param days liczba dni
     */
    public void setDays(Double days) {
        this.days = days;
    }

    /**
     * Funkcja dodająca dowolną iloścć dni do licznika w klasie.
     * @param x liczba dni jakie mają zostać dodane
     */
    public void add(Double x){
        this.days+=x;
    }
}
