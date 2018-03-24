import java.util.Calendar;

/**
 * Klasa formatująca datę w postaci ciągu znaków RRRR-MM-DD do kalendarza zawierającego tą datę lub na odwrót
 * @author Karolina Piekarz
 */
public class DateFormater {

    /**
     * Fynkcja formatująca datę w postaci ciągu znaków do kalendarza
     * @param dateStr data w postaci RRRR-MM-DD
     * @return kalendarz zawierajacy datępodaną jako argument
     */
    public Calendar format(String dateStr){
        int year = Integer.parseInt(dateStr.substring(0, 4));
        int month = Integer.parseInt(dateStr.substring(5, 7))-1;
        int day = Integer.parseInt(dateStr.substring(8, 10));

        Calendar cal = Calendar.getInstance();
        cal.set(year,month,day);
        return cal;

    }

    /**
     * Funkcja formatująca datę zawartą w kalendarzu do ciągu znaków
     * @param cal kalendarz zawierajacy datę
     * @return data w postaci ciągu znaków RRRR-MM-DD
     */
    public String format(Calendar cal){
        String date = "";
        date+=cal.get(Calendar.YEAR)+ "-";
        int month = cal.get(Calendar.MONTH)+1;
        if(month<10){
            date += "0" + month;
        }
        else{
            date += month;
        }
        date += "-";
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if(day<10){
            date += "0" + day;
        }
        else{
            date += day;
        }

        return date;
    }

}
