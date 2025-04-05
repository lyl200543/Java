package ListTest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * ClassName: erex1
 * Package: ListTest
 * Description:创建于 2025/4/5 9:49
 * 案例:键盘录入学生信息，保存到集合List中。
 * (1)定义学生类，属性为姓名、年龄，提供必要的getter、setter方法，构造器，toString()，equals()方法
 * (2)使用ArrayList集合，保存录入的多个学生对象
 * (3)循环录入的方式，1:继续录入，0:结束录入。
 * (4)录入结束后，用foreach遍历集合
 *
 * @Author lyl
 * @Version 1.0
 */
public class erex1 {
    public static void main (String[] args) {
        ArrayList list = new ArrayList();
        System.out.println("请录入学生的信息");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1:继续录入，0:结束录入");
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.print("请输入学生的姓名：");
                String name = scanner.next();
                System.out.print("请输入学生的年龄：");
                int age = scanner.nextInt();
                list.add(new Student(name , age));
            } else if (num == 0)
                break;
            else
                throw new RuntimeException("输入格式不正确");
        }
        scanner.close();

        System.out.println("遍历学生信息：");
        for (Object stu : list) {
            System.out.println(stu);
        }
    }

}

class Student {
    private String name;
    private int age;

    public Student () {
    }

    public Student (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public final boolean equals (Object o) {
        if (! (o instanceof Student student)) return false;

        return age == student.age && Objects.equals(name , student.name);
    }


}