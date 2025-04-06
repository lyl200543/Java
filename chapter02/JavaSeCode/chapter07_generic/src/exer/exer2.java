package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * ClassName: exer2
 * Package: exer
 * Description:创建于 2025/4/6 15:31
 * (1)创建一个ArrayList集合对象，并指定泛型为<Integer>
 * (2)添加5个[0,100)以内的随机整数到集合中
 * (3)使用foreach遍历输出5个整数
 * (4)使用集合的removeIf方法删除偶数，为Predicate接口指定泛型<Ineteger>
 * (5)再使用Iterator迭代器输出剩下的元素，为Iterator接口指定泛型<Integer>
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    @Test
    public void test () {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            list.add((int) (Math.random() * 100));
        }
        for (Integer value : list) {
            System.out.println(value);
        }

        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test (Integer integer) {
                //返回为true时删除
                return integer % 2 == 0;
            }
        });

        System.out.println();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
