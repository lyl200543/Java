package Dateexer;

import java.time.LocalDateTime;

/**
 * ClassName: exer2
 * Package: Dateexer
 * Description:创建于 2025/4/4 9:25
 * 使用Calendar/LocalDateTime获取当前时间，把这个时间设置为你的生日，再获取你的百天(出生后100天)日期。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static void main (String[] args) {
//        Calendar calendar =Calendar .getInstance() ;
//        System.out.println(calendar.getTime() );
//        calendar .set(2005,3,30); //month从[0,11]
//        System.out.println(calendar.getTime() );
//        calendar .add(Calendar .DATE ,100);
//        System.out.println(calendar.getTime() );

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.of(2005 , 4 , 30 , 1 , 25 , 49);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = localDateTime1.plusDays(100);
        System.out.println(localDateTime2);
    }

}
