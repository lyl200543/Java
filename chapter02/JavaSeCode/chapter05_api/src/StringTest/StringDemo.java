package StringTest;

import org.junit.Test;

/**
 * ClassName: StringDemo
 * Package: StringTest
 * Description:创建于 2025/4/2 15:27
 *
 * @Author lyl
 * @Version 1.0
 */
public class StringDemo {

    //当对字符串变量重新赋值时，需要重新指定一个字符串常量的位置进行赋值，不能在原有的位置修改
    @Test
    public void test1 () {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);

        s2 = "world";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    //当对现有的字符串进行拼接操作时，需要重新开辟空间（堆空间）保存拼接以后的字符串，不能在原有的位置修改
    @Test
    public void test2 () {
        String s1 = "hello";
        String s2 = "hello";
        s2 += " world";

        System.out.println(s1);
        System.out.println(s2);
    }

    //当调用字符串的replace()替换现有的某个字符时，需要重新开辟空间（堆空间）保存修改以后的字符串，不能在原有的位置修改
    @Test
    public void test3 () {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s2.replace('l' , 'w');

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    //String的连接操作:+
    @Test
    public void test4 () {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = "hello" + s2;
        String s6 = s1 + "world";
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);

        System.out.println();
        String s8 = s7.intern();
        System.out.println(s3 == s8);

        System.out.println();
        String s9=s1.concat("world");
        String s10="hello".concat("world");
        String s11=s1.concat(s2);
        String s12="hello".concat(s2);
        System.out.println(s9==s10);
        System.out.println(s9==s11);
        System.out.println(s9==s12);

    }
}
