package ListTest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: exer2
 * Package: ListTest
 * Description:创建于 2025/4/5 10:17
 * 穿例:
 * 定义方法public static int listTest(collection list,string s)统计集合中指定元素出现的次数
 * (1)创建集合，集合存放随机生成的30个小写字母
 * (2)用listTest统计，a、b、c、x元素的出现次数
 * (3)效果如下
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static int listTest (Collection list , String s) {
        int count = 0;
        for (Object str : list) {
            if (str.equals(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0 ; i < 30 ; i++) {
            //小写字母的ASCII的为97-122
//            int num = (int) (Math.random() * 26 + 97);
//            char[] arr = new char[]{(char) num};
//            list.add(new String(arr));

            list.add((char) (Math.random() * 26 + 97) + "");
        }

        System.out.println(list);
        System.out.println("a:" + listTest(list , "a"));
        System.out.println("b:" + listTest(list , "b"));
        System.out.println("c:" + listTest(list , "c"));
        System.out.println("x:" + listTest(list , "x"));

    }
}
