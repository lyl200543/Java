package SetTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName: TreeSet
 * Package: SetTest
 * Description:创建于 2025/4/5 15:13
 *
 * @Author lyl
 * @Version 1.0
 */
public class TreeSetTest {
    @Test
    public void test1 () {
        TreeSet set = new TreeSet();
        set.add("zhangsan");
        set.add("wangwu");
        set.add("lisi");
        //set.add(123);  //报错：ClassCastException
        //TreeSet中的元素的类型必须一致

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());


    }

    //自然排序：
    @Test
    public void test2 () {
        TreeSet set = new TreeSet();
        set.add(new Person("zhangsan" , 23));
        set.add(new Person("wangwu" , 45));
        set.add(new Person("lisi" , 18));
        set.add(new Person("xiaoming" , 18));
        //报错：java.lang.ClassCastException: class SetTest.Person cannot be cast to class java.lang.Comparable
        //TreeSet的对象必须要有排序方法

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }

    //定制排序：
    @Test
    public void test3 () {

        Comparator comparator = new Comparator() {
            @Override
            public int compare (Object o1 , Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;

                    int value = p1.getName().compareTo(p2.getName());
                    if (value != 0)
                        return value;
                    return - (p1.getAge() - p2.getAge());
                }
                throw new RuntimeException("类型不匹配");
            }
        };

        TreeSet set = new TreeSet(comparator);
        set.add(new Person("zhangsan" , 23));
        set.add(new Person("wangwu" , 45));
        set.add(new Person("lisi" , 18));
        set.add(new Person("xiaoming" , 18));

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
