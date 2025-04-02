package StringTest;

import org.junit.Test;

/**
 * ClassName: StringMethodMore
 * Package: StringTest
 * Description:创建于 2025/4/2 18:48
 *
 * @Author lyl
 * @Version 1.0
 */
public class StringMethodMore {
    @Test
    public void test1 () {
        //trim()
        String s1 = "   hel  lo  ";
        System.out.println(s1.trim());

        //compateTo(String s)
        String s2 = "abcd";
        String s3 = "aBcd";
        System.out.println(s2.compareToIgnoreCase(s3));
    }

    @Test
    public void test2 () {
        String s1 = "abcdabcd";
        System.out.println(s1.contains("abc"));

        System.out.println(s1.indexOf("bc"));
        System.out.println(s1.indexOf("bc" , 3));

        System.out.println(s1.lastIndexOf("bc"));
        System.out.println(s1.lastIndexOf("bc" , 4));
    }

    @Test
    public void test3 () {
        String s1 = "尚硅谷教育";
        String s2 = s1.substring(3);
        System.out.println(s2);

        //java中，凡是涉及从某个索引到另一个索引的都是[a,b)(左闭右开)
        String s3 = s1.substring(0 , 3);
        System.out.println(s3);
    }

    @Test
    public void test4 () {
        String s1 = String.valueOf(new char[]{'a' , 'b' , 'c'});
        System.out.println(s1);

        String s2 = String.copyValueOf(new char[]{'a' , 'b' , 'c'});
        System.out.println(s2);
    }

    @Test
    public void test5 () {
        String s1 = "教育尚硅谷教育";
        System.out.println(s1.startsWith("教育"));
        System.out.println(s1.startsWith("教育" , 5));
        System.out.println(s1.endsWith("教育"));
    }
    
    @Test 
    public void test6(){
        String s1 = "hello";
        System.out.println(s1);
        String s2=s1.replace('l','w');
        System.out.println(s2);
        String s3=s1.replace("ll","wwww");
        System.out.println(s3);
    }
}
