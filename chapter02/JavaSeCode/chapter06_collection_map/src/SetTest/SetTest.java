package SetTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * ClassName: SetTest
 * Package: SetTest
 * Description:创建于 2025/4/5 13:35
 *
 * @Author lyl
 * @Version 1.0
 */
public class SetTest {
    @Test
    public void test1 () {
        HashSet hashSet = new HashSet();
        hashSet.add("lyl");
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(new Person("zeyu" , 17));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(hashSet.contains(new Person("zeyu" , 17)));
    }
    
    @Test 
    public void test2(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("lyl");
        linkedHashSet.add(123);
        linkedHashSet.add(123);
        linkedHashSet.add(new Person("zeyu" , 17));

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
