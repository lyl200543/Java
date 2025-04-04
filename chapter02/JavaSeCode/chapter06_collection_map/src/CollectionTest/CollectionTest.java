package CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: CollectionTest
 * Package: CollectionTest
 * Description:创建于 2025/4/4 19:53
 *
 * @Author lyl
 * @Version 1.0
 */
public class CollectionTest {
    @Test
    public void test1 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(123); //自动装箱
        coll.add(new Person("zeyu" , 17));
        System.out.println(coll);
        System.out.println(coll.size());


        Collection coll1 = new ArrayList();
        coll1.add("zhangsan");
        coll1.add(456);
        coll.addAll(coll1);
        //coll.add(coll1);   //使用add()添加一个集合时，整个集合看作一个元素
        System.out.println(coll);
        System.out.println(coll.size());
    }

    @Test
    public void test2 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(123);
        coll.add(new Person("zeyu" , 17));

        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test3 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        System.out.println(coll.contains("lyl"));
        System.out.println(coll.contains(128));
        System.out.println(coll.contains(new Person("zeyu" , 17)));

        Collection coll1 = new ArrayList();
        coll1.add("lyl");
        coll1.add(125);

        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test4 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        Collection coll1 = new ArrayList();
        coll1.add("lyl");
        coll1.add(128);

        coll.retainAll(coll1);
        System.out.println(coll);

        coll.remove(new Person("zeyu" , 17));
        System.out.println(coll);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test5 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        System.out.println(coll.hashCode());
        Object[] arr = coll.toArray();
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }

        Collection coll1 = new ArrayList();
        coll1.add("lyl");
        coll1.add(128);
        coll1.add(new Person("zeyu" , 17));
        System.out.println(coll.equals(coll1));
    }

    //集合与数组的相互转换
    @Test
    public void test6 () {
        Collection coll = new ArrayList();
        coll.add("lyl");
        coll.add(128);
        coll.add(new Person("zeyu" , 17));

        Object[] array = coll.toArray();
        for (int i = 0 ; i < array.length ; i++) {
            System.out.println(array[i]);
        }

        String[] strings = new String[]{"AA" , "BB" , "CC" , "DD"};
        List list = Arrays.asList(strings);
        List list1 = Arrays.asList("zhangsan","wangwu","lisi");

        System.out.println(list);
        System.out.println(list1);

    }

    @Test
    public void test7 () {
        Integer[] arr1 = new Integer[]{1 , 2 , 3};
        List list1 = Arrays.asList(arr1);
        System.out.println(list1.size());  //3
        System.out.println(list1);

        int[] arr2 = new int[]{1 , 2 , 3};
        List list2 = Arrays.asList(arr2);
        System.out.println(list2.size());  //1
        System.out.println(list2);

    }
}


class Person {
    String name;
    int age;

    public Person () {
    }

    public Person (String name , int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public final boolean equals (Object o) {
        if (! (o instanceof Person person)) return false;

        return age == person.age && Objects.equals(name , person.name);
    }

}