package exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName: exer1
 * Package: exer
 * Description:创建于 2025/4/6 15:05
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    //自然排序
    @Test
    public void test1 () {
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee("Tom" , new MyDate(1999 , 3 , 16)));
        set.add(new Employee("Jerry" , new MyDate(2005 , 4 , 30)));
        set.add(new Employee("Aile" , new MyDate(2012 , 8 , 8)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //定制排序：
    @Test
    public void test2 () {
        Comparator<Employee> comparator = new Comparator<>() {
            @Override
            public int compare (Employee o1 , Employee o2) {
                //错误方式：
                //当年份相同，月份为4和12时，会将月和2进行比较，会出错
                //return o1.getDate().toString().compareTo(o2.getDate().toString());

                //正确方式一：
//                int y = o1.getDate().getYear() - o2.getDate().getYear();
//                if (y != 0) {
//                    return y;
//                }
//                int m = o1.getDate().getMonth() - o2.getDate().getMonth();
//                if (m != 0) {
//                    return m;
//                }
//                return o1.getDate().getDay() - o2.getDate().getDay();

                //正确方式二：
                return o1.getDate().compareTo(o2.getDate());
            }
        };
        TreeSet<Employee> set = new TreeSet<>(comparator);
        set.add(new Employee("Tom" , new MyDate(1999 , 11 , 16)));
        set.add(new Employee("Jerry" , new MyDate(2005 , 4 , 30)));
        set.add(new Employee("Aile" , new MyDate(2012 , 8 , 8)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private MyDate date;

    @Override
    public int compareTo (Employee o) {
        return this.name.compareTo(o.name);
    }


    public Employee () {
    }

    public Employee (String name , MyDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    public MyDate getDate () {
        return date;
    }

    public void setDate (MyDate date) {
        this.date = date;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", date=[" + date +
                "]}";
    }
}


class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    @Override
    public int compareTo (MyDate o) {
        int y = this.getYear() - o.getYear();
        if (y != 0) {
            return y;
        }
        int m = this.getMonth() - o.getMonth();
        if (m != 0) {
            return m;
        }
        return this.getDay() - o.getDay();

    }

    public MyDate () {
    }

    public MyDate (int year , int month , int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public int getMonth () {
        return month;
    }

    public void setMonth (int month) {
        this.month = month;
    }

    public int getDay () {
        return day;
    }

    public void setDay (int day) {
        this.day = day;
    }

    @Override
    public String toString () {
        return year + "年" + month + "月" + day + "日";
    }
}