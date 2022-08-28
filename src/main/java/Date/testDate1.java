package Date;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-07 14:45
 */
public class testDate1 {

    public static void main(String[] args) {

        Calendar instance = Calendar.getInstance();
        Date end = instance.getTime();

        System.out.println(getDateOfEndTime(end));

        instance.add(Calendar.DAY_OF_MONTH,-6);
        Date start=instance.getTime();

        System.out.println(getDateOfStartTime(start));
    }

    private static Date getDateOfStartTime(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTime();
        }
    }

    private static Date getDateOfEndTime(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 999);
            return calendar.getTime();
        }
    }
}
