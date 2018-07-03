package pl.whiteit.booking.light.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String formatDateToBase(Date date) {
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        return df.format(date);
    }

    public static Date getYesterday(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }
}
