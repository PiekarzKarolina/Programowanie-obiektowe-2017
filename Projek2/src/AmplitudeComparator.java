import java.util.Comparator;

/**
 * Komparator porównujący dwie instancje klasy AskBidDifference.
 * @see AskBidDifference
 * @see PrinterNSorted
 * @see Comparator
 * @author Karolina Piekarz
 */
public class AmplitudeComparator implements Comparator<AskBidDifference> {
    /**
     * Funkcja porównująca dwie instancje klasy AskBidDifference o1 oraz o2. Porównuje ze soba wartość pola Amplitude.
     * @param o1 Element1 do porównania
     * @param o2 Element2 do porównania
     * @return zwraca 0 jezeli elementy są sobie równe, 1 jeżeli o1 jest większe od o2, -1 w przeciwnym wypadku.
     */
    @Override
    public int compare(AskBidDifference o1, AskBidDifference o2) {
        if(o1.getAmplitude()>o2.getAmplitude()) return -1;
        if(o1.getAmplitude()<o2.getAmplitude()) return 1;
        return 0;
    }
}
