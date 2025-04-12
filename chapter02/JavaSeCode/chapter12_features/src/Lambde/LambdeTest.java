package Lambde;

import org.junit.Test;

import java.util.Comparator;

/**
 * ClassName: Lambde.LambdeTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/12 18:54
 *
 * @Author lyl
 * @Version 1.0
 */
public class LambdeTest {
    @Test
    public void test1 () {
        Runnable runnable = new Runnable() {
            @Override
            public void run () {
                System.out.println("我爱北京天安门");
            }
        };
        runnable.run();

        //lambde表达式
        Runnable runnable1 = () -> System.out.println("我爱赏花");
        runnable1.run();
    }

    @Test
    public void test2 () {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare (Integer o1 , Integer o2) {
                return Integer.compare(o1 , o2);
            }
        };
        System.out.println(comparator.compare(12 , 23));

        //lambde表达式：
        Comparator<Integer> comparator1 = (o1 , o2) -> {
            return Integer.compare(o1 , o2);
        };
        System.out.println(comparator1.compare(21 , 19));
    }


    @Test
    public void test3 () {
        MyFunctionalInterface myFunctionalInterface = () -> "就这样莫名其妙地爱上你";
        System.out.println(myFunctionalInterface.method());
    }
}

//自定义函数式接口：
interface MyFunctionalInterface {
    public String method ();
}
