package SetTest;

import java.util.HashSet;

/**
 * ClassName: exer2
 * Package: SetTest
 * Description:创建于 2025/4/5 16:55
 * 案例:
 * 编写一个程序，获取10个1至20的随机数，要求随机数不能重复。并把最终的随机数输出到控制台。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static void PrintRandomNumber () {
        int count = 0;
        HashSet set = new HashSet();
        while (count < 10) {
            int num = (int) (Math.random() * 20 + 1);
            if (set.add(num))
                count++;
        }

        for (Object obj : set)
            System.out.println(obj);
    }

    public static void main (String[] args) {
        PrintRandomNumber();
    }
}
