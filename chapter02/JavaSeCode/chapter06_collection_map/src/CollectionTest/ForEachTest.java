package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: ForEachTest
 * Package: CollectionTest
 * Description:创建于 2025/4/4 21:49
 *
 * @Author lyl
 * @Version 1.0
 */
public class ForEachTest {
    @Test
    public void test1 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        for (Object obj : coll) {
            System.out.println(obj);
        }

    }

    @Test
    public void test2 () {
        String[] arr = new String[]{"aa" , "bb" , "cc"};




        for (String str : arr) {
            System.out.println(str);
        }
    }
}
