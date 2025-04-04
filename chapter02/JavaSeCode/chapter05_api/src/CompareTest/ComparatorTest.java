package CompareTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Comparator
 * Package: CompareTest
 * Description:创建于 2025/4/4 13:46
 *
 * @Author lyl
 * @Version 1.0
 */
public class ComparatorTest {
    @Test
    public void test1 () {
        Productor[] arr = new Productor[5];
        arr[0] = new Productor("HuaWei" , 6999.0);
        arr[1] = new Productor("XiaoMi" , 2999.0);
        arr[2] = new Productor("Vivo" , 2999.0);
        arr[3] = new Productor("Oppo" , 4999.0);
        arr[4] = new Productor("Iphone" , 19999.0);

        //接口Comparator中有两个抽象方法，一个是int compare(object o1,object 02),一个是boolean equals(object o)
        //只用重写compare()即可，因为接口的实现类继承于Object类，而Object类中的equals()可以看作是重写
        Comparator comparator = new Comparator() {
            @Override
            public int compare (Object o1 , Object o2) {
                if (o1 instanceof Productor && o2 instanceof Productor) {
                    Productor p1 = (Productor) o1;
                    Productor p2 = (Productor) o2;

                    //按价格从大到小
                    return - Double.compare(p1.getPrice() , p2.getPrice());
                }
                throw new RuntimeException("类型不匹配");
            }
        };

        Arrays.sort(arr , comparator);
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }

    @Test
    public void test2 () {
        String[] arr = new String[]{"zhangsan" , "wangwu" , "lisi" , "xiaoming" , "lili"};
        Comparator comparator = new Comparator() {
            @Override
            public int compare (Object o1 , Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return -s1.compareTo(s2);
                }

                throw new RuntimeException("类型不匹配");
            }
        };

        Arrays.sort(arr , comparator);
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
