package Stringexer;

import org.junit.Test;

/**
 * ClassName: exer5
 * Package: exer
 * Description:创建于 2025/4/2 19:56
 * 获取两个字符串中最大相同子串。比如:题目4:
 * str1 = "abcwerthelloyuiodef"
 * str2 = "cvhellobnm"
 * 提示:将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer5 {

    @Test
    public void test () {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(getMaxSubString(str1 , str2));
    }

    public String getMaxSubString (String str1 , String str2) {
        if (str1.length() <= str2.length()) {
            int count = 0;
            while (count < str1.length()) {
                for (int i = 0 ; i <= count ; i++) {
                    String tmp = str1.substring(i , str1.length() - count + i);
                    if (str2.contains(tmp))
                        return tmp;
                }
                count++;
            }
        } else {
            int count = 0;
            while (count < str2.length()) {
                for (int i = 0 ; i <= count ; i++) {
                    String tmp = str2.substring(i , str2.length() - count + i);
                    if (str1.contains(tmp))
                        return tmp;
                }
                count++;
            }
        }
        return null;
    }
}

