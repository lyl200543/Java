package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ClassName: IteratorTest
 * Package: CollectionTest
 * Description:创建于 2025/4/4 21:35
 *
 * @Author lyl
 * @Version 1.0
 */
public class IteratorTest {
    @Test
    public void test1 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
