import org.junit.Test;

import java.util.*;

/**
 * ClassName: CollectionsTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/6 9:43
 *
 * @Author lyl
 * @Version 1.0
 */
public class CollectionsTest {
    @Test
    public void test1 () {
        /**
         *reverse(List):反转 List 中元素的顺序
         * shuffle(List):对 List 集合元素进行随机排序
         * sort(List):根据元素的自然顺序对指定 List 集合元素按升序排序
         * sort(List，Comparator):根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
         * swap(List，int， int):将指定 list 集合中的 i 处元素和 j 处元素进行交换
         */

        List list = Arrays.asList(45 , 78 , 56 , 89 , 12 , 36);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list , new Comparator() {
            @Override
            public int compare (Object o1 , Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return - (i1 - i2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(list);

    }

    @Test
    public void test2 () {
        /**
         * 0bject max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
         * 0bject max(Collection，Comparator):根据 Comparator 指定的顺序，返回给定集合中的最大元素
         * object min(Collection):根据元素的自然顺序，返回给定集合中的最小元素
         * 0bject min(Collection，Comparator):根据 Comparator 指定的顺序，返回给定集合中的最小元素
         * int binarySearch(list list,T key):在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且必须是可比较大小的，即支持自然排序的。而且集合也事先必须是有序的，否则结果不确定。
         * int binarySearch(List list,T key,comparator c)在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且集合也事先必须是按照c比较器规则进行排序过的，否则结果不确定。
         * int frequency(collectionc，Objecto):返回指定集合中指定元素的出现次数*/

        List list = Arrays.asList(45 , 78 , 56 , 89 , 12 , 36 , 45);
        System.out.println(list);

        System.out.println(Collections.max(list));
        Object max1 = Collections.max(list , new Comparator() {
            @Override
            public int compare (Object o1 , Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return - (i1 - i2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(max1);

        System.out.println(Collections.frequency(list , 45));
    }

    //copy()注意点：
    @Test
    public void test3 () {
        List src = Arrays.asList(45 , 78 , 56 , 89 , 12 , 36 , 45);
        System.out.println(src);

        //错误做法：
        //报错：java.lang.IndexOutOfBoundsException: Source does not fit in dest
        //Collections中的copy()的定义如下：
        //int srcSize = src.size();
        //if (srcSize > dest.size())
        //    throw new IndexOutOfBoundsException("Source does not fit in dest");

//        ArrayList dest = new ArrayList();
//        System.out.println(dest.size());  //size为0
//        Collections.copy(dest , src);


        //正确做法：
        List dest = Arrays.asList(new Object[src.size()]);
        System.out.println(dest.size());
        Collections.copy(dest , src);
        System.out.println(dest);
    }

    @Test
    public void test4 () {
        //提供了多个unmodifiablexxx()方法，该方法返回指定 xxx的不可修改的视图。
        ArrayList list1 = new ArrayList();
        list1.add(56);
        list1.add(36);
        list1.add(19);
        System.out.println(list1);

        List list2 = Collections.unmodifiableList(list1);
        //报错：java.lang.UnsupportedOperationException
        list2.add(78);
    }

    @Test
    public void test5 () {
        ArrayList list = new ArrayList();
        List list1 = Collections.synchronizedList(list);
        list1.add(123);

    }
}
