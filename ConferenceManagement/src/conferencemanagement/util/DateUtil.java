package conferencemanagement.util;

import conferencemanagement.model.Constants;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public DateUtil() {
        super();
    }
    private static Calendar calendar;
    private static Date date;
    private static SimpleDateFormat sdf;
    public static Date getDate() {
        calendar = Calendar.getInstance();
        date = calendar.getTime();
        return date;
    }
    public static Date getDateForSession(String sessionType) {
        Calendar calendar = Calendar.getInstance();
        if(Constants.SESSION_TYPE_MORNING.equals(sessionType)) {
            calendar.set(Calendar.HOUR_OF_DAY, 9);    
        }
        else {
            calendar.set(Calendar.HOUR_OF_DAY, 13);    
        }
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        return date;
    }
    public static Calendar getCalendarForSession(String sessionType) {
        Calendar calendar = Calendar.getInstance();
        if(Constants.SESSION_TYPE_MORNING.equals(sessionType)) {
            calendar.set(Calendar.HOUR_OF_DAY, 9);    
        }
        else {
            calendar.set(Calendar.HOUR_OF_DAY, 13);    
        }
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }
    public static String getTime(Date date) {
        sdf = new SimpleDateFormat("hh:mm a");
        String timeString = sdf.format(date);
        return timeString;
    }
    public static void main(String[] args) {
        Date date = getDateForSession(Constants.SESSION_TYPE_AFTERNOON);
        System.out.println("Date:" + date);
        System.out.println(getTime(date));
    }
}
