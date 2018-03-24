import org.junit.Test;

import java.util.Calendar;

public class GoldPriceTest {


    @Test
    public void getgoldPriceTest() {

        Calendar cal = Calendar.getInstance();
        cal.set(2018,0,17);

        GoldPrice price = new GoldPrice();

        try {
           assert price.getgoldPrice(cal, "Cena")==146.61;
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
