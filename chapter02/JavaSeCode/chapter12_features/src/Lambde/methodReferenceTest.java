package Lambde;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ClassName: referenceTest
 * Package: Lambde
 * Description:创建于 2025/4/12 20:27
 *
 * @Author lyl
 * @Version 1.0
 */

//方法引用的使用：
public class methodReferenceTest {
    //情况一：对象::实例方法
    @Test
    public void test1 () {
        //1.
        Consumer<String> con1 = new Consumer<>() {
            @Override
            public void accept (String s) {
                System.out.println(s);
            }
        };
        con1.accept("hellp");

        //2.
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("abc");

        //3.
        Consumer<String> con3 = System.out::println;
        con3.accept("I love you");
    }

    @Test
    public void test2 () {
        //1.
        Employee emp = new Employee("zhangsan");
        Supplier<String> sup1 = new Supplier<String>() {
            @Override
            public String get () {
                return emp.getName();
            }
        };
        System.out.println(sup1.get());

        //2.
        Supplier<String> sup2 = () -> emp.getName();
        System.out.println(sup2.get());

        //3.
        Supplier<String> sup3 = emp::getName;
        System.out.println(sup3.get());
    }

    //情况二：类::静态方法
    @Test
    public void test3 () {
        //1.
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare (Integer o1 , Integer o2) {
                return Integer.compare(o1 , o2);
            }
        };
        System.out.println(com1.compare(12 , 21));

        //2.
        Comparator<Integer> com2 = (o1 , o2) -> Integer.compare(o1 , o2);
        System.out.println(com2.compare(45 , 24));

        //3.
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com3.compare(23 , 23));
    }

    @Test
    public void test4 () {
        //1.
        Function<Double, Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply (Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(fun1.apply(3.4));

        //2.
        Function<Double, Long> fun2 = aDouble -> Math.round(aDouble);
        System.out.println(fun2.apply(3.9));

        //3.
        Function<Double, Long> fun3 = Math::round;
        System.out.println(fun3.apply(4.5));
    }

    //情况三：类::实例方法
    @Test
    public void test5 () {
        //1.
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare (String o1 , String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare("abc" , "aog"));

        //2.
        Comparator<String> com2 = ((o1 , o2) -> o1.compareTo(o2));
        System.out.println(com2.compare("123" , "789"));

        //3.
        Comparator<String> com3 = String::compareTo;
        System.out.println(com3.compare("shgo" , "oidfhe"));

    }

    @Test
    public void test6 () {
        //1.
        BiPredicate<String, String> b1 = new BiPredicate<String, String>() {
            @Override
            public boolean test (String s , String s2) {
                return s.equals(s2);
            }
        };
        System.out.println(b1.test("sfd" , "sfd"));

        //2.
        BiPredicate<String, String> b2 = (s1 , s2) -> s1.equals(s2);
        System.out.println(b2.test("sof" , "sih"));

        //3.
        BiPredicate<String, String> b3 = String::equals;
        System.out.println(b3.test("sdf" , "sdf"));

    }

    @Test
    public void test7 () {
        //1.
        Employee emp = new Employee("lusi");
        Function<Employee, String> fun1 = new Function<Employee, String>() {
            @Override
            public String apply (Employee employee) {
                return employee.getName();
            }
        };
        System.out.println(fun1.apply(emp));

        //2.
        Function<Employee, String> fun2 = employee -> employee.getName();
        System.out.println(fun2.apply(emp));

        //3.
        Function<Employee, String> fun3 = Employee::getName;
        System.out.println(fun3.apply(emp));
    }
}
