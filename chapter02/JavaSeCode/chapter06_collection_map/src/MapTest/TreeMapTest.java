package MapTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * ClassName: TreeMapTest
 * Package: MapTest
 * Description:创建于 2025/4/5 20:19
 *
 * @Author lyl
 * @Version 1.0
 */
public class TreeMapTest {
    @Test
    public void test1 () {
        //按照key属性（String）的自然排序进行排序
        TreeMap map = new TreeMap();
        map.put("zhangsan" , 69);
        map.put("wangwu" , 79);
        map.put("lisi" , 96);
        map.put("wangwu" , 9);
        //lisi=96
        //wangwu=9
        //zhangsan=69
        //第二个"wangwu”被发现存在相同元素，于是进行修改，将值从79改为9

        Set set = map.entrySet();
        for (Object obj : set)
            System.out.println(obj);
    }

    //自然排序
    @Test
    public void test2 () {
        TreeMap map = new TreeMap();
        map.put(new Person("zhangsan" , 18) , 69);
        map.put(new Person("wangwu" , 25) , 79);
        map.put(new Person("lisi" , 22) , 96);

        Set set = map.entrySet();
        for (Object obj : set)
            System.out.println(obj);
    }

    //定制排序
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
                    return p1.getAge() - p2.getAge();
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        TreeMap map = new TreeMap(comparator);
        map.put(new Person("zhangsan" , 18) , 69);
        map.put(new Person("wangwu" , 25) , 79);
        map.put(new Person("lisi" , 22) , 96);

        Set set = map.entrySet();
        for (Object obj : set)
            System.out.println(obj);
    }
}
