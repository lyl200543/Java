import ClassTest.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: ReflectionTEst
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/12 9:21
 *
 * @Author lyl
 * @Version 1.0
 */
public class ReflectionTest {
    //是否使用反射的区别
    @Test
    public void test1 () {
        Person p = new Person();
        System.out.println(p);

        p.name = "zhangsan";
        System.out.println(p.name);

        p.show();
    }

    @Test
    public void test2 () throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        System.out.println(p);

        Field namefield = clazz.getField("name");
        namefield.set(p , "wangwu");
        System.out.println(namefield.get(p));

        Method showMethod = clazz.getMethod("show");
        showMethod.invoke(p);
    }

    @Test
    public void test3 () throws Exception {
        //通过反射调用私有属性
        Class<Person> cls = Person.class;
        Constructor<Person> cons = cls.getDeclaredConstructor(String.class , int.class);
        cons.setAccessible(true);
        Person p = cons.newInstance("lisi" , 19);
        System.out.println(p);

        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p , 25);
        System.out.println(p);

        Method showNationMethod = cls.getDeclaredMethod("showNation" , String.class);
        showNationMethod.setAccessible(true);
        String nation = (String) showNationMethod.invoke(p , "CHN");
        System.out.println(nation);
    }


    //获取Class实例的方法：
    @Test
    public void test4 () throws ClassNotFoundException {
        //1.使用运行时类的静态属性class
        Class<User> cls1 = User.class;
        System.out.println(cls1);

        //2.使用运行时类的对象的方法getClass()
        User user = new User();
        Class cls2 = user.getClass();
        System.out.println(cls1 == cls2);

        //3.使用Class的静态方法forName(String className)
        Class cls3 = Class.forName("ClassTest.User");  //全类名
        System.out.println(cls1 == cls3);

        //4.使用类的加载器
        Class cls4 = ClassLoader.getSystemClassLoader().loadClass("ClassTest.User");
        System.out.println(cls1 == cls4);
    }
}


class Person {
    public String name;
    private int age;

    public Person () {
    }

    private Person (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public void show () {
        System.out.println("我是一个Person");
    }

    private String showNation (String nation) {
        return "我来自：" + nation;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}