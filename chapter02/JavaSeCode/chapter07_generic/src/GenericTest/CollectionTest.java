package GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: CollectionTest
 * Package: GenericTest
 * Description:创建于 2025/4/6 14:38
 *
 * @Author lyl
 * @Version 1.0
 */
public class CollectionTest {
    @Test
    public void test1 () {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //ArrayList<Integer> list  = new ArrayList<>();  //后面的尖括号中的类型可省略
        list.add(45);
        list.add(28);
        list.add(69);
        //list.add("AA");  //报错：java: 不兼容的类型: java.lang.String无法转换为java.lang.Integer

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            int i = value;
            System.out.println(i);
        }

    }

    @Test
    public void test2 () {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zhangshan" , 19);
        map.put("wangwu" , 29);
        map.put("lisi" , 12);

//        Set<Map.Entry<String, Integer>> set = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        //jdk10新特性：var
        var set = map.entrySet();
        var iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
