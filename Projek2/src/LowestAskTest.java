import org.junit.Test;

import java.util.Calendar;

public class LowestAskTest {

    @Test
    public void findLowestAskTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018,0,17);

        TableC table = new TableC();

        LowestAsk finder = new LowestAsk();

        try {
            assert finder.findLowestAsk(cal, table, "Currency", "Ask").equalsIgnoreCase("forint (Węgry)");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
