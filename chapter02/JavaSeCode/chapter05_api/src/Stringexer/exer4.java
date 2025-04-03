package Stringexer;

import org.junit.Test;

/**
 * ClassName: exer4
 * Package: exer
 * Description:创建于 2025/4/2 19:55
 * 题目3:获取一个字符串在另一个字符串中出现的次数。
 * 比如:获取"ab"在"abkkcadkabkebfkabkskab"中出现的次数
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer4 {

    @Test
    public void test(){
        String s1="abkkcadkabkebfkabkskab";
        String s2="ab";
        System.out.println(stringAppearNumber(s1 , s2));
    }

    public int stringAppearNumber (String sour , String dest) {
        int number = 0;
        int length = dest.length();
        int index = sour.indexOf(dest);
        while (index != - 1) {
            number++;
            if (index + length < sour.length())
                index = sour.indexOf(dest , index + length);
            else
                break;
        }
        return number;
    }
}
