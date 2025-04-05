package MapTest;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: HashMapTest
 * Package: MapTest
 * Description:创建于 2025/4/5 17:42
 *
 * @Author lyl
 * @Version 1.0
 */
public class HashMapTest {
    @Test
    public void test1 () {
        //增
        HashMap hashMap = new HashMap();
        hashMap.put("zhangsan" , 99);
        hashMap.put(45 , "BB");
        hashMap.put(new Person("zeyu" , 17) , 123);

        System.out.println(hashMap);

        //删(键)
        Object value = hashMap.remove("zhangsan");
        System.out.println(value);
        System.out.println(hashMap);

        //改(键)
        hashMap.put(89 , "BB");
        System.out.println(hashMap);

    }

    @Test
    public void test2 () {
        HashMap hashMap = new HashMap();
        hashMap.put("zhangsan" , 99);
        hashMap.put(45 , "BB");
        hashMap.put(new Person("zeyu" , 17) , 123);

        //遍历key集：
        Set keyset = hashMap.keySet();
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        //遍历value集：
        //方式一：
        Collection values = hashMap.values();
        for (Object obj : values)
            System.out.println(obj);

        //方式二：
        Set keyset1 = hashMap.keySet();
        for (Object key : keyset1) {
            Object value = hashMap.get(key);
            System.out.println(value);
        }

    }

    @Test
    public void test3 () {
        //遍历entry集：
        HashMap hashMap = new HashMap();
        hashMap.put("zhangsan" , 99);
        hashMap.put(45 , "BB");
        hashMap.put(new Person("zeyu" , 17) , 123);

        //方式一：
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            //方法一：
            //Map是一个接口，Entry是Map的内部接口，HashMap是Map的一个实现类
            //Node是HashMap的内部类，也是Entry的一个实现类
            //为了能够调用 Map.Entry 接口定义的 getKey() 和 getValue() 等方法来方便地获取键和值
            //就将返回值强制转换为 Map.Entry 类型。
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "---->" + entry.getValue());

            //方法二：
            //System.out.println(iterator.next());
        }

        //方式二：
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            System.out.println(key + "----->" + hashMap.get(key));
        }
    }
}
