package Lambde;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ClassName: constructorReferenceTest
 * Package: Lambde
 * Description:创建于 2025/4/12 21:40
 *
 * @Author lyl
 * @Version 1.0
 */
public class constructorReferenceTest {
    @Test
    public void test1 () {
        //1.
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get () {
                return new Employee();
            }
        };
        System.out.println(sup1.get());

        //2.
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    @Test
    public void test2 () {
        //1.
        Function<String, Employee> fun1 = new Function<String, Employee>() {
            @Override
            public Employee apply (String s) {
                return new Employee(s);
            }
        };
        System.out.println(fun1.apply("zhangsan"));

        //2.
        Function<String, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply("wangwu"));
    }

    @Test
    public void test3 () {
        //1.
        BiFunction<String, Integer, Employee> b1 = new BiFunction<String, Integer, Employee>() {
            @Override
            public Employee apply (String s , Integer integer) {
                return new Employee(s , integer);
            }
        };
        System.out.println(b1.apply("lisi" , 89));

        //2.
        BiFunction<String, Integer, Employee> b2 = Employee::new;
        System.out.println(b2.apply("lyl" , 19));

    }

    //数组引用
    @Test
    public void test4 () {
        //1.
        Function<Integer, Employee[]> f1 = new Function<Integer, Employee[]>() {
            @Override
            public Employee[] apply (Integer length) {
                return new Employee[length];
            }
        };
        System.out.println(f1.apply(10).length);

        //2.
        Function<Integer, Employee[]> f2 = Employee[]::new;
        System.out.println(f2.apply(20).length);
    }
}
