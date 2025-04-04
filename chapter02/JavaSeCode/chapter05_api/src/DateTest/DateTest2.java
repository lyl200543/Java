package DateTest;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * ClassName: DateTest2
 * Package: DateTest
 * Description:创建于 2025/4/4 8:49
 *
 * @Author lyl
 * @Version 1.0
 */

//JDK8之后
public class DateTest2 {
    @Test
    public void test1 () {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDate localDate1 = LocalDate.of(2030 , 4 , 30);
        LocalTime localTime1 = LocalTime.of(13 , 42 , 24);
        LocalDateTime localDateTime1 = LocalDateTime.of(2058 , 5 , 8 , 15 , 9 , 45);
        System.out.println(localDate1);
        System.out.println(localTime1);
        System.out.println(localDateTime1);
    }

    @Test
    public void test2 () {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfMonth());

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(9);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusDays(5);
        System.out.println(localDateTime2);
    }

    @Test
    public void test3 () {
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant1 = Instant.ofEpochMilli(155846168784L);
        System.out.println(instant1);

        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void test4 () {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        //TemporalAccessor是LocalDateTime实现的一个接口
        TemporalAccessor parse = dateTimeFormatter.parse("2025-04-04 09:29:36");
        LocalDateTime from = LocalDateTime.from(parse);
        System.out.println(from);

    }
}
