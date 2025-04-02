package StringTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * ClassName: StringMethod
 * Package: StringTest
 * Description:创建于 2025/4/2 16:54
 *
 * @Author lyl
 * @Version 1.0
 */
public class StringMethod {
    //String类型与其他类型或结构的相互转化
    //1.String与基本数据类型，包装类
    @Test
    public void test1 () {
        int num = 10;
        String s1 = num + "";
        System.out.println(s1);

        String s2 = String.valueOf(num);
        System.out.println(s2);
    }

    @Test
    public void test2 () {
        String s1 = "123";
        int num = Integer.parseInt(s1);
        System.out.println(num);
    }


    //2.String与char[]
    //char[] --> String :String的构造器
    @Test
    public void test3 () {
        char[] chars = new char[]{'a' , 'b' , 'c'};
        String s1 = new String(chars);
        System.out.println(s1);
    }

    //String --> char[] :调用toCharArray()方法
    @Test
    public void test4 () {
        String s1 = new String("abc");
        char[] chars = s1.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            System.out.println(chars[i]);
        }
    }

    //3.String与byte[](注意字符集编码和解码)
    @Test
    public void test5 () throws UnsupportedEncodingException {
        //String--> byte[] :通过getBytes()方法
        String s1 = new String("abc中国");
        //使用默认字符集（utf-8）,每个汉字占3个字节
        byte[] b1 = s1.getBytes();
        for (int i = 0 ; i < b1.length ; i++) {
            System.out.println(b1[i]);
        }

        //指定字符集（如：gbk），每个汉字占2个字节
        byte[] b2 = s1.getBytes("gbk");
        for (int i = 0 ; i < b2.length ; i++) {
            System.out.println(b2[i]);
        }

        //byte[] --> String :通过String的构造器
        String s2=new String(b1);
        System.out.println(s2);

        String s3=new String(b2,"gbk");
        System.out.println(s3);
    }
}
