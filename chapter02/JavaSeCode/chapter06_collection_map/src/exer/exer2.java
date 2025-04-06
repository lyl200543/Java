package exer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ClassName: exer2
 * Package: exer
 * Description:创建于 2025/4/6 11:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static void main (String[] args) {
        String[] num = {"A" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "J" , "Q" , "K"};
        String[] color = {"方片" , "梅花" , "红桃" , "黑桃"};
        ArrayList poker = new ArrayList();
        for (int i = 0 ; i < color.length ; i++) {
            for (int j = 0 ; j < num.length ; j++) {
                poker.add(color[i] + num[j]);
            }
        }
        poker.add("大王");
        poker.add("小王");

        Collections.shuffle(poker);

        ArrayList zhangsan = new ArrayList();
        ArrayList wangwu = new ArrayList();
        ArrayList me = new ArrayList();
        ArrayList lastcard = new ArrayList();
        for (int i = 0 ; i < poker.size() ; i++) {
            if (i >= poker.size() - 3) {
                lastcard.add(poker.get(i));
            } else if (i % 3 == 0) {
                zhangsan.add(poker.get(i));
            } else if (i % 3 == 1) {
                wangwu.add(poker.get(i));
            } else if (i % 3 == 2) {
                me.add(poker.get(i));
            }
        }

        System.out.println("zhagnsan:");
        System.out.println(zhangsan);
        System.out.println("wangwu:");
        System.out.println(wangwu);
        System.out.println("me:");
        System.out.println(me);
        System.out.println("lastcard:");
        System.out.println(lastcard);
    }
}
