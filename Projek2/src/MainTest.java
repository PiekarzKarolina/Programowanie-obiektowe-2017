import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

public class MainTest {
    static Double average;

    @BeforeClass
    public static void executedBeforeTest(){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2018,0,15);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(2018,0,16);

        Calendar cal3 = Calendar.getInstance();
        cal3.set(2018,0,17);

        GoldPrice price = new GoldPrice();

        try {
            average = (price.getgoldPrice(cal1, "Cena") + price.getgoldPrice(cal2, "Cena") + price.getgoldPrice(cal3, "Cena"))/3;
            average = Math.round(average * 100D) / 100D;
        }
        catch (Exception e){
            e.printStackTrace();
        }
     }

     @Test
    public void test(){
         Calendar cal1 = Calendar.getInstance();
         cal1.set(2018,00,15);
         Calendar cal2 = Calendar.getInstance();
         cal2.set(2018,00,17);
         GoldRecord gold = new GoldRecord();
         AverageCalculator calc = new AverageCalculator();
         try {
             assert calc.computeAverage(cal1, cal2, gold, "Cena").equals(average);
         }
         catch (Exception e){
             e.printStackTrace();
         }
     }

}
