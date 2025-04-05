package SetTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName: exer1
 * Package: SetTest
 * Description:创建于 2025/4/5 16:16
 * 案例:
 * 定义方法如下:public static List duplicateList(List list)
 * 要求:①参数List中只存放Integer的对象在List内去除重复数字值，尽量简单
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
//    public static List duplicateList (List list) {
//        for (int i = 0 ; i < list.size() ; i++) {
//            for (int j = i + 1 ; j < list.size() ; j++) {
//                if (list.get(i).equals(list.get(j)))
//                    list.set(j , "*");
//            }
//        }
//        ArrayList sign = new ArrayList();
//        sign.add("*");
//        list.removeAll(sign);
//        return list;
//    }

    //使用set
    public static List duplicateList (List list) {
//        HashSet set = new HashSet();
//        for (Object obj : list)
//            set.add(obj);
//
//        ArrayList newlist = new ArrayList();
//        for (Object obj : set) {
//            newlist.add(obj);
//        }
//
//        return newlist;

        HashSet set = new HashSet(list);
        ArrayList newlist = new ArrayList(set);
        return newlist;
    }

    public static void main (String[] args) {
        List list = new ArrayList();
        list.add(45);
        list.add(45);
        list.add(45);
        list.add(45);
        list.add(78);
        list.add(78);
        list.add(78);
        list.add(78);
        list.add(99);
        list.add(99);
        list.add(99);
        list.add(99);
        list.add(18);
        list.add(18);
        list.add(18);
        list.add(18);
        list.add(18);
        list.add(45);

        List newlist = duplicateList(list);
        System.out.println(newlist);
    }

}
