package Dateexer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ClassName: exer1
 * Package: Dateexer
 * Description:创建于 2025/4/3 19:34
 * 练习:
 * 如何将一个java.util.Date的实例转换为java.sql.Date的实例
 * 拓展:
 * 将控制台获取的年月日(比如:2022-12-13)的字符串数据
 * 保存在数据库中(简化为得到java.sql.Date的对象，此对象对应的时间为2022-12-13)。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    //    如何将一个java.util.Date的实例转换为java.sql.Date的实例
//    Date d1 = new Date();
//    java.sql.Date d2 = new java.sql.Date(d1.getTime());

    public static void main (String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(string);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        scanner.close();
    }
}
