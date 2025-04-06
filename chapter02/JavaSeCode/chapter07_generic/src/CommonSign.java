import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CommonSign
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/6 20:00
 *
 * @Author lyl
 * @Version 1.0
 */
public class CommonSign {
    @Test
    public void test1 () {
        ArrayList<Object> list = null;
        ArrayList<String> list1 = null;

        //list = list1;  //报错
        method(list);
        //method(list1);  //报错
        //为解决泛型参数通用性不高的问题-->使用通配符?

        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list2 = list3;
    }

    public static void method (ArrayList<Object> list) {

    }


    @Test
    public void test2 () {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        List<Object> list2 = null;

        method1(list);
        method1(list1);
        //method1(list2);   //报错

    }

    public static void method1 (ArrayList<?> list) {
        //读取数据：
        Object object = list.get(0);

        //写入数据：
        //list.add("aa");   //报错
        list.add(null);
    }

    @Test
    public void test3 () {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Father> list1 = new ArrayList<>();
        ArrayList<Son> list2 = new ArrayList<>();

        //method2(list);   //报错
        method2(list1);
        method2(list2);

        method3(list);
        method3(list1);
        //method3(list2);   //报错

    }

    public static void method2 (ArrayList<? extends Father> list) {
        //读取数据：
        Father father = list.get(0);

        //写入数据：
        //list.add(new Object());
        //list.add(new Father());
        //list.add(new Son());     //报错
        list.add(null);
    }

    public static void method3 (ArrayList<? super Father> list) {
        //读取数据：
        Object object = list.get(0);

        //写入数据：
        //list.add(new Object());  //报错
        list.add(new Father());
        list.add(new Son());
        list.add(null);
    }

}


class Father {

}

class Son extends Father {

}