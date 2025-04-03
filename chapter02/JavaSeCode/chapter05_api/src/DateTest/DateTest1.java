package DateTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DateTest1
 * Package: DateTest
 * Description:创建于 2025/4/3 17:03
 *
 * @Author lyl
 * @Version 1.0
 */
public class DateTest1 {
    @Test
    public void test1 () {
        Date d1 = new Date();
        System.out.println(d1.toString());
        System.out.println(d1.getTime());

        Date d2 = new Date(4856231559858L);
        System.out.println(d2);

        java.sql.Date d3 = new java.sql.Date(459665498465L);
        System.out.println(d3);
    }

    @Test
    public void test2 () throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();  //默认格式
        Date d1 = new Date();
        System.out.println(sdf.format(d1));  // 2025/4/3 19:00

        Date d2 = sdf.parse("2025/4/3 19:00");
        System.out.println(d2);
    }

    @Test
    public void test3 () throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date();
        System.out.println(sdf.format(d1));

        Date d2 = sdf.parse("2025-04-03 19:10:50");
        System.out.println(d2);
    }

    @Test
    public void test4 () {
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.getClass());

        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        c1.set(Calendar.DAY_OF_MONTH , 8);
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        c1.add(Calendar.DAY_OF_MONTH , 2);
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        //Date --> Calendar
        Date d1 = c1.getTime();
        System.out.println(d1);

        //Calendar --> Date
        c1.setTime(new Date());
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
    }
}
