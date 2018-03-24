

import java.util.Calendar;


public class AverageCalculatorTest {


    @org.junit.Test
    public void computeAverageTest() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2018,00,16);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2018,00,17);
        GoldRecord gold = new GoldRecord();
        AverageCalculator calc = new AverageCalculator();
        try {
            assert calc.computeAverage(cal1, cal2, gold, "Cena")==146.53;
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
