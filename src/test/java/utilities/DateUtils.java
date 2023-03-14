package utilities;

import automation_test.mortgage_calculator.CalculateMortgageRate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth(){
        Date dNow = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dNow);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(Calendar.MONTH,1);
        //For next month, if you add amount: 3 it's going to be 3 months later
        String date = sdf.format(calendar.getTime());
        return date.split("-");
    }

}
