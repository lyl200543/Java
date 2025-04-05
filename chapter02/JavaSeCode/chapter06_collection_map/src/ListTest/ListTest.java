package ListTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: ListTest
 * Package: ListTest
 * Description:创建于 2025/4/5 9:15
 *
 * @Author lyl
 * @Version 1.0
 */
public class ListTest {
    @Test
    public void test1 () {
        List list = new ArrayList();
        list.add("lyl");
        list.add(123);
        list.add(new Person1("zeyu" , 17));

        System.out.println(list);  //底层使用迭代器

        list.add(2 , 2);
        list.add(2 , "AA");
        System.out.println(list);

        //remove()传入数字时，默认为索引
//        list.remove(2);
//        System.out.println(list);

        //要想删除数字，则需要手动装箱
        list.remove(Integer.valueOf(2));
        System.out.println(list);

        //遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object obj : list) {
            System.out.println(obj);
        }

        for (int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}

class Person1 {
    String name;
    int age;

    public Person1 () {
    }

    public Person1 (String name , int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public final boolean equals (Object o) {
        if (! (o instanceof Person1 person)) return false;

        return age == person.age && Objects.equals(name , person.name);
    }

}