
import org.junit.Test;

import java.util.Calendar;


public class CurrencyPriceTest {

    @Test
    public void getcurrencyPriceTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 00, 17);

        try {
            CurrencyPrice curr = new CurrencyPrice();
            assert curr.getcurrencyPrice(cal, "JPY", "Mid")==0.030801;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
