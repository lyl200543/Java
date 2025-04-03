package StringBufferAndStringBuilder;

import org.junit.Test;

/**
 * ClassName: methodTest
 * Package: StringBufferAndStringBuilder
 * Description:创建于 2025/4/3 15:30
 *
 * @Author lyl
 * @Version 1.0
 */
public class methodTest {
    @Test
    public void test1 () {
        StringBuilder str1 = new StringBuilder();
        str1.append("abc").append("123");
        System.out.println(str1);
    }

    @Test
    public void test2 () {
        StringBuilder str1 = new StringBuilder("hello");
        str1.insert(2 , "ww");
        System.out.println(str1);
        System.out.println(str1.reverse());
    }

    @Test
    public void test3 () {
        StringBuilder str1 = new StringBuilder("hello");
        str1.setLength(2);
        System.out.println(str1);
        str1.setLength(10);
        System.out.println(str1);
        System.out.println(str1.charAt(6) == 0);
    }
}
