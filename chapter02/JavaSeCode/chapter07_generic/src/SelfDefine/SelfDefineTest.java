package SelfDefine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ClassName: SelfDefineTest
 * Package: SelfDefine
 * Description:创建于 2025/4/6 16:57
 *
 * @Author lyl
 * @Version 1.0
 */
public class SelfDefineTest {
    @Test
    public void test1 () {
        Order order = new Order();
        Object t = order.getT();

        Order<String> order1 = new Order<>();
        String t1 = order1.getT();
    }

    @Test
    public void test2 () {
        SubOrder1 s1 = new SubOrder1();
        Object t = s1.getT();

        SubOrder2 s2 = new SubOrder2();
        Integer t1 = s2.getT();

        SubOrder3<String> s3 = new SubOrder3<>();
        String t2 = s3.getT();

        SubOrder4<String> s4 = new SubOrder4<>();
        Integer t3 = s4.getT();
        String e = s4.getE();

        SubOrder5<Integer, String> s5 = new SubOrder5<>();
        Integer t4 = s5.getT();
        String e1 = s5.getE();


    }

    @Test
    public void test3 () {
        ArrayList<Integer> list = Order.fromArrayToList(new Integer[]{1 , 2 , 3 , 4 , 5});
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }
}
