package date;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-06 11:08
 */
public class testDate {

    public static void main(String[] args) {


        testDate testDate = new testDate();

        Date date = new Date();

        System.out.println(date.toString());

        Date date1 = testDate.getDateOfEndTime(date);

        System.out.println(date1.toString());



    }

    public Date getDateOfStartTime(Date date) {
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


    public Date getDateOfEndTime(Date date) {
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
