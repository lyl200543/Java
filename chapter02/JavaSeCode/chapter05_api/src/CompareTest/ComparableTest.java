package CompareTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: ComparableTest
 * Package: CompareTest
 * Description:创建于 2025/4/4 12:56
 *
 * @Author lyl
 * @Version 1.0
 */
public class ComparableTest {
    @Test
    public void test1 () {
        String[] arr = new String[]{"zhangsan" , "wangwu" , "lisi" , "xiaoming" , "lili"};
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2 () {
        Productor[] arr = new Productor[5];
        arr[0] = new Productor("HuaWei" , 6999.0);
        arr[1] = new Productor("XiaoMi" , 2999.0);
        arr[2] = new Productor("Vivo" , 2999.0);
        arr[3] = new Productor("Oppo" , 4999.0);
        arr[4] = new Productor("Iphone" , 19999.0);

        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }
}

class Productor implements Comparable {
    private String name;
    private double price;

    public Productor () {
    }

    public Productor (String name , double price) {
        this.name = name;
        this.price = price;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    @Override
    public String toString () {
        return "Productor{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //大于返回正数，小于返回负数，相等返回0
    //如果想颠倒顺序，则在返回值前加-
    @Override
    public int compareTo (Object o) {
        if (this == o)
            return 0;
        if (o instanceof Productor) {
            Productor p = (Productor) o;
            //先比较价格，再比较名字
            int value = Double.compare(this.price , p.price);
            if (value != 0)
                return value;

            return this.name.compareTo(p.name);

        }

        throw new RuntimeException("类型不匹配");
    }
}